package com.example.pra4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        val submit = findViewById<Button>(R.id.submit)
        val input_drink = findViewById<EditText>(R.id.input_drink)
        val sweet = findViewById<RadioGroup>(R.id.radio_sweet)
        val ice = findViewById<RadioGroup>(R.id.radio_ice)

        submit.setOnClickListener{
            if(input_drink.length()<1)
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()
            else{
                val bundle = Bundle()
                bundle.putString("input_drink",input_drink.text.toString())
                bundle.putString("sweet",sweet.findViewById<RadioButton>(sweet.checkedRadioButtonId).text.toString())
                bundle.putString("ice",ice.findViewById<RadioButton>(ice.checkedRadioButtonId).text.toString())

                setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
                finish()

            }
        }

    }

}