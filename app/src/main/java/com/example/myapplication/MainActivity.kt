package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Board.BoardActivity
import com.example.myapplication.Character.CharacterActivity
import com.example.myapplication.Dog.DogActivity
import com.example.myapplication.English.EnglishActivity
import com.example.myapplication.Family.FamilyActivity
import com.example.myapplication.Food.FoodActivity
import com.example.myapplication.Gyudong.GyudongActivity
import com.example.myapplication.Korean.KoreanActivity
import com.example.myapplication.Music.MusicActivity
import com.example.myapplication.Seoi.SeoiActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
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
        val dogPageButton: Button = findViewById(R.id.dog)
        dogPageButton.setOnClickListener {
            val intent = Intent(this, DogActivity::class.java)
            startActivity(intent)
        }
        val EnglishPageButton: Button = findViewById(R.id.English)
        EnglishPageButton.setOnClickListener {
            val intent = Intent(this, EnglishActivity::class.java)
            startActivity(intent)
        }
        val FamilyPageButton: Button = findViewById(R.id.Family)
        FamilyPageButton.setOnClickListener {
            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }
        val FoodPageButton: Button = findViewById(R.id.Food)
        FoodPageButton.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }
        val GyudongPageButton: Button = findViewById(R.id.Gyudong)
        GyudongPageButton.setOnClickListener {
            val intent = Intent(this, GyudongActivity::class.java)
            startActivity(intent)
        }
        val KoreanPageButton: Button = findViewById(R.id.Korean)
        KoreanPageButton.setOnClickListener {
            val intent = Intent(this, KoreanActivity::class.java)
            startActivity(intent)
        }
        val MusicPageButton: Button = findViewById(R.id.Music)
        MusicPageButton.setOnClickListener {
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
        val SeoilPageButton: Button = findViewById(R.id.Seoi)
        SeoilPageButton.setOnClickListener {
            val intent = Intent(this, SeoiActivity::class.java)
            startActivity(intent)
        }
    }
}
