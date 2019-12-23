package com.example.efpcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentDate()
        textViewDOBResult.setOnClickListener { dateTimePicker() }
    }

    private fun dateTimePicker() {

        var age: Int
        var minBasicSave: Double

        val c: Calendar = Calendar.getInstance()
        val currentDay = c.get(Calendar.DAY_OF_MONTH)
        val currentMonth = c.get(Calendar.MONTH) + 1
        val currentYear = c.get(Calendar.YEAR)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                view, year, month, day ->
                textViewDOBResult.text = day.toString() + "/" +
                        (month + 1).toString() + "/" + year.toString()

                age = currentYear - year
                minBasicSave = getMinSave(age)
                displayResult(age, minBasicSave)

            }, currentYear, currentMonth, currentDay)

        dpd.show()
    }

    private fun getMinSave(age: Int): Double {

        return when(age) {
            in 16..20 -> 5000.00
            in 21..25 -> 14000.00
            in 26..30 -> 29000.00
            in 31..35 -> 50000.00
            in 36..40 -> 78000.00
            in 41..45 -> 116000.00
            in 46..50 -> 165000.00
            in 51..55 -> 228000.00
            else -> 0.0
        }

    }

    private fun displayResult(age: Int, minBasicSave: Double) {

        textViewAgeResult.text = age.toString()
        textViewMinBasicSaveResult.text = "RM $minBasicSave"
        textViewAllowInvestResult.text = "RM " + (minBasicSave * 0.3)

    }

    private fun setCurrentDate() {

        val c: Calendar = Calendar.getInstance()
        val currentDay = c.get(Calendar.DAY_OF_MONTH)
        val currentMonth = c.get(Calendar.MONTH) + 1
        val currentYear = c.get(Calendar.YEAR)

        textViewDOBResult.text = "$currentDay/$currentMonth/$currentYear"

    }

}
