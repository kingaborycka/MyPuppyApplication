package com.example.mypuppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.PendingIntent.getActivity
import androidx.fragment.app.DialogFragment
import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        Food_B.setOnClickListener{
            var nowaAktywnosc: Intent = Intent(applicationContext, FoodActivity::class.java)
            startActivity(nowaAktywnosc)
        }

        Toilet_B.setOnClickListener{
            var nowaAktywnosc: Intent = Intent(applicationContext, ToiletActivity::class.java)
            startActivity(nowaAktywnosc)
        }


    }
}
