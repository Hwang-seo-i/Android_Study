package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Board.BoardActivity
import com.example.myapplication.Character.CharacterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardPageButton: Button = findViewById(R.id.btnBoard)
        boardPageButton.setOnClickListener {
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }
        val characterPageButton: Button = findViewById(R.id.characterRanking)
        characterPageButton.setOnClickListener {
            val intent = Intent(this, CharacterActivity::class.java)
            startActivity(intent)
        }
    }
}
