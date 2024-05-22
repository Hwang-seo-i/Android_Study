package com.example.myapplication.Character

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class CharacterActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE_CHAR_ADD = 100
        val REQUEST_CODE_CHAR_EDIT = 101
    }

    private val Characterlist = dummyData()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_character)

        // 더미 데이터 띄우기
        val adapter = CharacterAdapter(Characterlist)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.characterList)
        recyclerView.adapter = adapter

        val btnAddPlus = findViewById<android.widget.ImageButton>(id.btnAddPlus)
        btnAddPlus.setOnClickListener {
            // 캐릭터 추가 액티비티로 이동
            val intent = android.content.Intent(this, AddCharacterActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE_CHAR_ADD)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: android.content.Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        android.util.Log.d("CharacterActivity", "onActivityResult: requestCode: $requestCode, $data")

        if(resultCode == RESULT_OK) {
            val name = data?.getStringExtra("name")

            if(requestCode == REQUEST_CODE_CHAR_ADD) {
                Characterlist.add(CharacterDataClass(name!!))
            } else if(requestCode == REQUEST_CODE_CHAR_EDIT) {
                val position = data?.getIntExtra("position", -1)

            }
            // 데이터 변경 후 RecyclerView 갱신
            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.characterList)
            recyclerView.adapter?.notifyDataSetChanged()

        }
    }
}