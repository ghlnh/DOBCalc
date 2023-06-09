package lnh.tutorials.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	
	//텍스트뷰를 지금은 초기화하지 않지만 나중에 변수를 부여할 수 있어 널러블로 설정
	private var tvSelectedDate : TextView? = null
	private var tvAgeInMinutes : TextView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//btnDatePicker가 버튼이름이 아님! 변수명임
		val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
		tvSelectedDate = findViewById(R.id.tvSelectedDate)
		tvAgeinMinutes = findViewById(R.id.tvAgeInMinutes)
		//실제 버튼을 클릭 시 발생하는 이벤트 설정(토스트)
		btnDatePicker.setOnClickListner {
				clickDatePicker()
				}
		}

//다른 클래스에서 clickDatePicker()를 사용하지 못하도록 private로 설정
	private fun clickDatePicker(){
		//DatePickerDialog를 위한 변수들
		val myCalendar = Calendar.getinstance()
		val year = myCalendar.get(Calendar.YEAR)
		val month = myCalendar.get(Calendar.MONTH)
		val day = myCalendar.get(Calendar.DAY_OF_MONTH)		
		val dpd = DatePickerDialog(this,

//_를 사용하여 특정 매개변수를 생략 가능
				 DatePickerDialog.OnDateSetListener{ _, selectedYear, selectedMonth
																								, selectedDayOfMonth ->
					Toast.makeText(this,
//1월을 0으로 보고 계산하기 때문에 월+1 해줘야 함
							"Year was $selectedYear, month was ${selectedMonth+1}
							, day of month was $selectedDayOfMonth ", Toast.LENGTH_LONG).show()
					val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
					tvSelectedDate?.text = selectedDate

				//SimpleDateFormat은 날짜에 사용할 패턴과 언어를 정의해줌
					val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH

					val theDate = sdf.parse(selectedDate)
				//날짜를 선택해야 실행되도록 함
				theDate?.let{	
					val selectedDateInMinutes = theDate.time/ 60000
					
					val currentDate = sdf.parse(sdf.format(System.currentTimeMills()))
					currentDate?.let{
					val currentDateInMinutes = currentDate.time/ 60000

					val differnceInMinutes = currentDateInMinutes - selectedDateInMinutes

					tvAgeInMinutes?.text = differnceInMinutes.toString()}
				}		
			
				//ms 단위라 60000으로 나눔
			},
			year,
			month,
			day
			)
		//어제 날짜까지만 선택할 수 있게 제한 설정
			dpd.datePicker.maxDate = System.currentTimeMillis()-86400000
			dpd.show()

	}
