package com.example.myapplication.Family

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class AddFamilyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_add_family)

        val nameText = findViewById<android.widget.TextView>(id.text_input_name)

        if (intent.getBooleanExtra("edit_mode", false)) {
            findViewById<android.widget.EditText>(id.text_input_name).setText(intent.getStringExtra("name"))
        }

        val btnAddDog = findViewById<android.widget.TextView>(id.btnsave)
        btnAddDog.setOnClickListener {
            val name = nameText.text.toString().trim()

            if (name.isNotEmpty()) {
                intent.putExtra("name", name)
                intent.putExtra("position", this.intent.getIntExtra("position", 0))

                setResult(android.app.Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}