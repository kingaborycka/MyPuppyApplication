package com.example.mypuppy

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.typeOf


val monthsMap = mapOf(1 to "Styczeń", 2 to "Luty", 3 to "Marzec", 4 to "Kwiecień", 5 to "Maj", 6 to "Czerwiec", 7 to "Lipiec", 8 to "Sierpień", 9 to "Wrzesień", 11 to "Listopad", 12 to "Grudzień")
val daysMap = mapOf( 1 to "ND.", 2 to "PN.", 3 to "WT.", 4 to "ŚR.", 5 to "CZW.", 6 to "PT.", 7 to "SOB.")

class MainActivity : AppCompatActivity() {

    var td_year = Calendar.getInstance().get(Calendar.YEAR)
    var td_month = Calendar.getInstance().get(Calendar.MONTH)+1
    var td_day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    var td_dayOfWeek = daysMap[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)]
    var td_date = "$td_year-$td_month-$td_day"

    fun setDate(date: String ){
        println("Dzisiaj jest:"+ td_date)
        td_date = date
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toilet = findViewById<EditText>(R.id.Toilet_MT)
        var food = findViewById<EditText>(R.id.Food_MT)
        var other = findViewById<EditText>(R.id.Other_MT)

        //ustawianie bieżącej daty
        Month_TV.setText(monthsMap[td_month])
        Day_TV.setText("$td_dayOfWeek $td_day")


        //wybieranie daty

        Date_TV.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val newFragment = DateDialog()
                newFragment.show(
                    this@MainActivity.getSupportFragmentManager(),
                    "datePicker"
                )
            }
        })

        Food_B.setOnClickListener{
            var newActivity: Intent = Intent(applicationContext, FoodActivity::class.java)

            //przekazywanie daty z MainActivity
            newActivity.putExtra("month",Month_TV.text)
            newActivity.putExtra("day",Day_TV.text)

            startActivity(newActivity)
        }

        Toilet_B.setOnClickListener{
            var newActivity: Intent = Intent(applicationContext, ToiletActivity::class.java)

            //przekazywanie daty z MainActivity
            newActivity.putExtra("month",Month_TV.text)
            newActivity.putExtra("day",Day_TV.text)

            startActivity(newActivity)
        }
    }


//    fun getData(){
//
//
//    }
}

class DateDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity!!, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val daysOfWeekMap = mapOf("Sun" to 1, "Mon" to 2, "Tue" to 3, "Wed" to 4, "Thu" to 5, "Fri" to 6, "Sat" to 7)
        var dialog_month = month + 1
        var dialog_day = day
        var date = SimpleDateFormat("yyyy-MM-dd").parse("$year-$dialog_month-$day")
        var dialog_dayOfWeek = daysOfWeekMap[date.toString().split(" ")[0]]!!.toInt()

        //Ustawianie daty!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        activity!!.Month_TV.setText(monthsMap[dialog_month])
        activity!!.Day_TV.setText(daysMap[dialog_dayOfWeek]+" $dialog_day")
    }
}


