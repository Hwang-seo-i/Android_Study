package com.example.myapplication.Board

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.*

class BoardActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE_ADD = 100
        val REQUEST_CODE_EDIT = 101
    }
    private val list = dummyData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_board)

        // 데이터 리스트를 이용해 어댑터 생성
        val adapter = BoardAdapter(list)

        // RecyclerView에 어댑터 설정
        // RecyclerView는 Adapter를 통해 데이터를 화면에 표시하기 때문에 Adapter를 설정해야 함
        // Adapter는 데이터를 뷰로 변환하여 화면에 표시해주는 역할
        // BoardAdapter에서 할 일 :
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.boardList)
        recyclerView.adapter = adapter

        // btnAddPlus 버튼 클릭 시 AddBoard 액티비티로 이동
        val btnAddPlus = findViewById<android.widget.ImageButton>(id.btnAddPlus)
        btnAddPlus.setOnClickListener {
            val intent = Intent(this, AddBoardActivity::class.java)

            // startActivity : 새 액티비티를 열다(단방향)
            // startActivityForResult : 새 액티비티를 열고 결과값 전달(쌍방향)
            startActivityForResult(intent, REQUEST_CODE_ADD)
        }
    }

    // AddBoardActivity에서 결과값을 받아 처리
    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            val title = data?.getStringExtra("title")
            val date = data?.getStringExtra("date")

            if(requestCode == REQUEST_CODE_ADD) {

            } else if(requestCode == REQUEST_CODE_EDIT){

            }

            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.boardList)
            recyclerView.adapter?.notifyDataSetChanged()
        }

        // requestCode가 REQUEST_CODE_ADD이고 resultCode가 RESULT_OK이면
        // AddBoardActivity에서 intent로 받은 데이터를 BoardDataClass로 변환하여 board에 추가
        if (requestCode == REQUEST_CODE_ADD && resultCode == android.app.Activity.RESULT_OK) {
            val title = data?.getStringExtra("title")
            val date = data?.getStringExtra("date")
            if ( title != null && date != null) {
                val board = BoardDataClass(list.last().number + 1, title, date)
                list.add(board)
            }
            // 추가된 게시판 데이터로 뷰 갱신
            // 게시판 데이터가 추가되면 RecyclerView를 갱신해야 함
            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.boardList)
            recyclerView.adapter?.notifyDataSetChanged()
        }


        // requestCode가 REQUEST_CODE_EDIT이고 resultCode가 RESULT_OK이면
        // EditBoardActivity에서 intent로 받은 데이터를 BoardDataClass로 변환하여 board에 수정
        if (requestCode == REQUEST_CODE_EDIT && resultCode == android.app.Activity.RESULT_OK) {
            val title = data?.getStringExtra("title")
            val date = data?.getStringExtra("date")
            val position = data?.getIntExtra("position", 0)
            if ( position != null && title != null && date != null) {
                val board = BoardDataClass(position + 1, title, date)
                list[position] = board
            }
            // 수정된 게시판 데이터로 뷰 갱신
            val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(id.boardList)
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }
}

