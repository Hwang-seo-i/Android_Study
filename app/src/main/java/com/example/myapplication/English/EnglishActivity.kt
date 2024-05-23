package com.example.myapplication.English

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class EnglishActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE_ENG_ADD = 200
        val REQUEST_CODE_ENG_EDIT = 201
    }

    private val Englishlist = dummyData()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_character)

        // 더미 데이터 띄우기
        val adapter = EnglishAdapter(Englishlist)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.characterList)
        recyclerView.adapter = adapter

        val btnAddPlus = findViewById<android.widget.ImageButton>(id.btnAddPlus)
        btnAddPlus.setOnClickListener {
            // 영어 추가 액티비티로 이동
            val intent = android.content.Intent(this, AddEnglishActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE_ENG_ADD)
        }
    }

    @SuppressLint("NotifyDataSetChanged", "SuspiciousIndentation")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: android.content.Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        android.util.Log.d("EnglishActivity", "onActivityResult: requestCode: $requestCode, $data")

        if(resultCode == RESULT_OK) {
            val word = data?.getStringExtra("word")

            if(requestCode == REQUEST_CODE_ENG_ADD) {
                Englishlist.add(EnglishDataClass(word!!))
            } else if(requestCode == REQUEST_CODE_ENG_EDIT) {
                val position = data?.getIntExtra("position", -1)
                    if(position != null && position != -1 && word != null) {
                        val english = Englishlist[position]
                        english.word = word
                        Englishlist[position] = english
                }
            }
            // 데이터 변경 후 RecyclerView 갱신
            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.characterList)
            recyclerView.adapter?.notifyDataSetChanged()

        }
    }
}