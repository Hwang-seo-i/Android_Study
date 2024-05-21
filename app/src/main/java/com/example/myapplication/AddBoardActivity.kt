package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class AddBoardActivity : AppCompatActivity() {

    private val list = dummyData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_board)

        // 편집 모드에서, intent에서 제목과 날짜 데이터 받아서 textinput에 설정
        if (intent.getBooleanExtra("edit_mode", false)) {
            findViewById<TextInputEditText>(R.id.text_input_title).setText(intent.getStringExtra("title"))
            findViewById<TextInputEditText>(R.id.text_selected_date).setText(intent.getStringExtra("date"))
        }

        //  titleText : 제목 입력
        val titleText = findViewById<TextView>(R.id.text_input_title)

        //  calendar 객체 생성
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        //  text_selected_date 클릭 시 DatePickerDialog 띄우기
        val textSelectedDate = findViewById<TextView>(R.id.text_selected_date)
        textSelectedDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, month, dayOfMonth ->
                    textSelectedDate.text = "${year}- ${month + 1}- ${dayOfMonth}"
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        // btnsave : 저장버튼
        //  btnAddBoard 클릭 시 게시글 추가
        val btnAddBoard = findViewById<TextView>(R.id.btnsave)
        btnAddBoard.setOnClickListener {

            //  제목과 선택한 날짜 가져오기
            // trim() : 문자열 앞뒤 공백 제거
            val title = titleText.text.toString().trim()
            val date = textSelectedDate.text.toString().trim()

            // 제목과 선택한 날짜가 비어있지 않으면 결과를 반환하고 액티비티를 종료
            if (title.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                //  게시판에 추가
                val number = if (list.isEmpty()) 1 else list.last().number + 1
                val board = BoardDataClass(number, title, date)
                list.add(board)

                // 결과를 인텐트에 담아서 이전 화면에 전달
                val intent = Intent(this, BoardActivity::class.java)
//                intent.putExtra("number", number)
                intent.putExtra("title", title)
                intent.putExtra("date", date)
                intent.putExtra("position", this.intent.getIntExtra("position", -1))
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}