package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 데이터 리스트를 실제 눈으로 볼 수 있게 item으로 변환하기 위해 Adapter를 사용
// BoardAdapter 클래스는 생성자에서 BoardDataClass 객체의 ArrayList를 매개변수로 받음
// ArrayList는 datalist 변수에 저장
class BoardAdapter(item: ArrayList<BoardDataClass>) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private var datalist = item

    // datalist의 크기 반환
    // RecyclerView의 아이템 개수를 반환
    override fun getItemCount(): Int {
        return datalist.size
    }

    // XML 레이아웃 파일에서 RecyclerView의 각 항목에 대한 레이아웃 인플레이트
    // 인플레이트 : XML 레이아웃 파일을 실제 뷰 객체로 만드는 과정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_list, parent, false)
        return ViewHolder(view)
    }

    // 생성된 ViewHolder에 데이터 바인딩 해주는 함수
    // Data binding : xml에 data 연결 작업
    // onBindViewHolder 메소드에서는 ViewHolder의 bind 메소드를 호출하여 데이터를 뷰에 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])

        // list item 클릭 시 이벤트 처리
        // 클릭되면 클릭된 항목의 데이터를 가진 Intent로 AddBoardActivity를 시작
        holder.itemView.setOnClickListener {
            val context = it.context as Activity
            val intent = Intent(context, AddBoardActivity::class.java).apply {
                putExtra("edit_mode", true)
                putExtra("position", position)
                putExtra("title", datalist[position].title)
                putExtra("date", datalist[position].date)
            }
            context.startActivityForResult(intent, 101)
        }
    }

    // ViewHolder : 어떤 데이터를 어디에 넣을건지 정해주는 함수
    // RecyclerView.ViewHolder를 상속받아 ViewHolder를 만들어줌
    // bind 메소드에서는 BoardDataClass의 데이터 뷰에 바인딩
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: BoardDataClass) {
            itemView.findViewById<TextView>(R.id.number_data).text = item.number.toString()
            itemView.findViewById<TextView>(R.id.title_data).text = item.title
            itemView.findViewById<TextView>(R.id.date_data).text = item.date
        }
    }
}

//[참고] : https://velog.io/@24hyunji/AndroidKotlin-RecyclerView-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0