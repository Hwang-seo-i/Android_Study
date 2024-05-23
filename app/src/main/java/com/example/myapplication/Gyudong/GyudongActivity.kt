package com.example.myapplication.Gyudong

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class GyudongActivity : AppCompatActivity(){

    companion object {
        val REQUEST_CODE_DOG_ADD = 100
        val REQUEST_CODE_DOG_EDIT = 101
    }

    private val GyuList = dummyData()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_dog)

        val adapter = GyudongAdapter(GyuList)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.dogList)
        recyclerView.adapter = adapter

        val btnAddPlus = findViewById<android.widget.ImageButton>(id.btnAddPlus)
        btnAddPlus.setOnClickListener {
            val intent = android.content.Intent(this, AddGyudongActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE_DOG_ADD)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: android.content.Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        android.util.Log.d("DogActivity", "onActivityResult: requestCode: $requestCode, $data")

        if(resultCode == RESULT_OK) {
            val name = data?.getStringExtra("name")

            if(requestCode == REQUEST_CODE_DOG_ADD) {
                GyuList.add(GyuDataClass(name!!))
            } else if(requestCode == REQUEST_CODE_DOG_EDIT) {
                val position = data?.getIntExtra("position", -1)
                    if(position != null && position != -1 && name != null) {
                        val Gyu = GyuList[position]
                        Gyu.name = name
                        GyuList[position] = Gyu
                }
            }
            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.dogList)
            recyclerView.adapter?.notifyDataSetChanged()

        }
    }
}