package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class BoardActivity : AppCompatActivity(), BoardDummyData {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_board)

        // 게시판 표시 더미데이터
        val list = dummyData()

        // 데이터 리스트를 이용해 어댑터 생성
        val adapter = BoardAdapter(list)

        // RecyclerView에 어댑터 설정
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.boardList)
        recyclerView.adapter = adapter
    }
}
