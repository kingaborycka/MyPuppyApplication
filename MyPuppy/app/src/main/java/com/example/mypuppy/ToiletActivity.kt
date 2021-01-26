package com.example.mypuppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_food.Cancel_B
import kotlinx.android.synthetic.main.activity_toilet.*

class ToiletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toilet)

        Month_TV.setText(intent.getStringExtra("month"))
        Day_TV.setText(intent.getStringExtra("day"))

        val spinnerOptions = resources.getStringArray(R.array.spinnerOptions)
        val spinner:Spinner = findViewById(R.id.spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, spinnerOptions)
            spinner.adapter = adapter
        }

        Cancel_B.setOnClickListener{
            var nowaAktywnosc: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(nowaAktywnosc)
        }
    }
}
