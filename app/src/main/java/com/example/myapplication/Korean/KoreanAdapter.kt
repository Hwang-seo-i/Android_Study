package com.example.myapplication.Korean

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.*

class KoreanAdapter(private val Characterlist: ArrayList<CharacterDataClass>) :
    RecyclerView.Adapter<KoreanAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name_data by lazy {
            itemView.findViewById<TextView>(id.name_data)
        }
        private val number_data by lazy {
            itemView.findViewById<TextView>(id.number_data)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: CharacterDataClass, position: Int) {
            name_data.text = item.name
            number_data.text = (position + 1).toString()

            itemView.setOnClickListener {
                val context = it.context as KoreanActivity
                val intent = android.content.Intent(itemView.context, AddKoreanActivity::class.java).apply {
                    putExtra("edit_mode", true)
                    putExtra("name", item.name)
                    putExtra("position", position)
                }
                context.startActivityForResult(intent, KoreanActivity.REQUEST_CODE_CHAR_EDIT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.character_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Characterlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Characterlist[position], position)
    }
}
