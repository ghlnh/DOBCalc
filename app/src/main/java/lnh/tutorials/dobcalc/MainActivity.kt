package lnh.tutorials.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	
	//텍스트뷰를 지금은 초기화하지 않지만 나중에 변수를 부여할 수 있어 널러블로 설정
	private var tvSelectedDate : TextView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//btnDatePicker가 버튼이름이 아님! 변수명임
		val btnDatePicker : Button = findViewById(r.id.btnDatePicker)
		tvSelectedDate = findvViewById(R.id.tvSelectedDate)
		//실제 버튼을 클릭 시 발생하는 이벤트 설정(토스트)
		btnDatePicker.setOnClickListner {
				clickDatePicker()
				}
		}

	fun clickDatePicker(){
		//DatePickerDialog를 위한 변수들
		val myCalendar = Calendar.getinstance()
		val year = myCalendar.get(Calendar.YEAR)
		val month = myCalendar.get(Calendar.MONTH)
		val day = myCalendar.get(Calendar.DAY_OF_MONTH)		
		DatePickerDialog(this,
				 DatePickerDialog.OnDateSetListener{ view, selectedYear, selectedMonth, selectedDayOfMonth ->
					Toast.makeText(this,
//1월을 0으로 보고 계산하기 때문에 월+1 해줘야 함
							"Year was $selectedYear, month was ${selectedMonth+1}
							, day of month was $selectedDayOfMonth ", Toast.LENGTH_LONG).show()
					val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
					tvSelectedDate?.text = selectedDate

				//SimpleDateFormat은 날짜에 사용할 패턴과 언어를 정의해줌
					val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH

					val theDate = sdf.parse(selectedDate)
			},
			year,
			month,
			day
			).show()

	}
