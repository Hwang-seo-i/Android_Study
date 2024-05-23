package com.example.myapplication.English

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.*

class EnglishAdapter(private val Englishlist: ArrayList<EnglishDataClass>) :
    RecyclerView.Adapter<EnglishAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name_data by lazy {
            itemView.findViewById<TextView>(id.name_data)
        }
        private val number_data by lazy {
            itemView.findViewById<TextView>(id.number_data)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: EnglishDataClass, position: Int) {
            name_data.text = item.word
            number_data.text = (position + 1).toString()

            itemView.setOnClickListener {
                val context = it.context as EnglishActivity
                val intent = Intent(itemView.context, AddEnglishActivity::class.java).apply {
                    putExtra("edit_mode", true)
                    putExtra("name", item.word)
                    putExtra("position", position)
                }
                context.startActivityForResult(intent, EnglishActivity.REQUEST_CODE_ENG_EDIT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.character_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Englishlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Englishlist[position], position)
    }
}