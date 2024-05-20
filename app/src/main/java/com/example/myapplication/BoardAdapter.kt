package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//데이터 리스트를 실제 눈으로 볼 수 있게 item으로 변환하기 위해 Adapter를 사용
class BoardAdapter(item: ArrayList<BoardDataClass>):RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private var datalist = item

    //  ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_list, parent, false)
        return ViewHolder(view)
    }

    // 생성된 ViewHolder에 데이터 바인딩 해주는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    // RecyclerView에 들어갈 데이터 갯수 반환
    override fun getItemCount(): Int {
        return datalist.size
    }

    //데이터가 틀 안에 들어가게 하는 역할
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: BoardDataClass){
            itemView.findViewById<TextView>(R.id.number_data).text = item.number.toString()
            itemView.findViewById<TextView>(R.id.title_data).text = item.content
            itemView.findViewById<TextView>(R.id.date_data).text = item.date
        }
    }
}

//[참고] : https://velog.io/@24hyunji/AndroidKotlin-RecyclerView-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0