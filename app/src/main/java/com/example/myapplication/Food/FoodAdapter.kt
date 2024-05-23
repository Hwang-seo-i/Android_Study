package com.example.myapplication.Food

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.*

class FoodAdapter(private val dogList: ArrayList<FoodDataClass>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name_data by lazy {
            itemView.findViewById<TextView>(id.name_data)
        }
        private val number_data by lazy {
            itemView.findViewById<TextView>(id.number_data)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: FoodDataClass, position: Int) {
            name_data.text = item.name
            number_data.text = (position + 1).toString()

            itemView.setOnClickListener {
                val context = it.context as FoodActivity
                val intent = android.content.Intent(itemView.context, AddFoodActivity::class.java).apply {
                    putExtra("edit_mode", true)
                    putExtra("name", item.name)
                    putExtra("position", position)
                }
                context.startActivityForResult(intent, FoodActivity.REQUEST_CODE_DOG_EDIT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.dog_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogList[position], position)
    }
}