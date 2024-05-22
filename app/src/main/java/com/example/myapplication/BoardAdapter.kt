package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 데이터 리스트를 실제 눈으로 볼 수 있게 item으로 변환하기 위해 Adapter를 사용
// BoardAdapter 클래스는 생성자에서 BoardDataClass 객체의 ArrayList를 매개변수로 받음
// ArrayList는 datalist 변수에 저장

// BoardAdapter는 BoardDataClass 객체의 ArrayList를 받아서 RecyclerView에 표시
class BoardAdapter(private val datalist: ArrayList<BoardDataClass>) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
//    private var datalist = item

    // ViewHolder : 어떤 데이터를 어디에 넣을건지 정해주는 클래스
    // RecyclerView.ViewHolder를 상속받아 ViewHolder를 만들어줌
    // bind 메소드에서는 BoardDataClass의 데이터 뷰에 바인딩
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val number_data by lazy {
            itemView.findViewById<TextView>(R.id.number_data)
        }


        fun bind(item: BoardDataClass) {
           number_data.text = item.number.toString()
            itemView.findViewById<TextView>(R.id.title_data).text = item.title
            itemView.findViewById<TextView>(R.id.date_data).text = item.date

            itemView.setOnClickListener {

            }
        }
    }

    private val tag = javaClass.simpleName
    // XML 레이아웃 파일에서 RecyclerView의 각 항목에 대한 레이아웃 인플레이트
    // 인플레이트 : XML 레이아웃 파일을 실제 뷰 객체로 만드는 과정

    // onCreateViewHolder 메소드에서는 RecyclerView의 각 항목에 대한 뷰 홀더 객체를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.e(tag, "onCreateViewHolder")
        // LayoutInflater를 이용하여 XML 레이아웃 파일을 실제 뷰 객체로 만들어줌
        // board_list.xml을 ViewHolder에 연결
        //parent : RecyclerView(생성된 뷰의 부모 뷰 지정)
        // attachToRoot : 생성된 뷰의 부모 뷰에 바로 추가할 지 여부를 의미하며, RecyclerView에서는 false로 설정
        // 이유는 RecyclerView가 뷰 홀더 패턴을 사용하기 때문
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_list, parent, false)
        return ViewHolder(view)
    }

    // 생성된 ViewHolder에 데이터 바인딩 해주는 함수
    // Data binding : xml에 data 연결 작업
    // onBindViewHolder 메소드에서는 ViewHolder의 bind 메소드를 호출하여 데이터를 뷰에 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e(tag, "onBindViewHolder")
        // BoardDataClass 객체의 ArrayList인 datalist에서 position에 해당하는 데이터를 가져와 bind 메소드 호출
        holder.bind(datalist[position])

        // list item 클릭 시 이벤트 처리
        // 클릭되면 클릭된 항목의 데이터를 가진 Intent로 AddBoardActivity를 시작
        holder.itemView.setOnClickListener {
            // 현재 뷰(it)의 context를 Activity로 형변환하여 context 변수에 저장
            // startActivityForResult를 사용하기 위해 context 변수를 사용하였고, Activity로 형변환하여 사용
            val context = it.context as Activity
            val intent = Intent(context, AddBoardActivity::class.java).apply {
                putExtra("edit_mode", true)
                putExtra("position", position)
                putExtra("title", datalist[position].title)
                putExtra("date", datalist[position].date)
            }

            context.startActivityForResult(intent, BoardActivity.REQUEST_CODE_EDIT)
        }
    }

    // datalist의 크기 반환
    // RecyclerView의 아이템 개수를 반환
    override fun getItemCount(): Int {
        Log.e(tag, "getItemCount")
        return datalist.size
    }
}

//[참고] : https://velog.io/@24hyunji/AndroidKotlin-RecyclerView-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0