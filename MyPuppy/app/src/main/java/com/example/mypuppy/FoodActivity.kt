package com.example.mypuppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        Month_TV.setText(intent.getStringExtra("month"))
        Day_TV.setText(intent.getStringExtra("day"))

        var kindOfFood = findViewById<EditText>(R.id.KindOfFood_editText)
        var quantity = findViewById<EditText>(R.id.Quantity_editText)
        var time = findViewById<EditText>(R.id.Time_editText)

        Cancel_B.setOnClickListener{
            var nowaAktywnosc: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(nowaAktywnosc)
        }
    }

}
