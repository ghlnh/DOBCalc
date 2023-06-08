package lnh.tutorials.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //btnDatePicker가 버튼이름이 아님! 변수명임
		val btnDatePicker : Button = findViewById(r.id.btnDatePicker)

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
				 DatePickerDialog.OnDateSetListener{ vies, year, month, dayOfMonth ->
					Toast.makeText(this,
								 "Datepicker works", Toast.LENGTH_LONG).show()
			},
			year,
			month,
			day
			).show()
}
