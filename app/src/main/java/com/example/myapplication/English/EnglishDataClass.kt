package com.example.myapplication.English

data class EnglishDataClass(
    var word: String
)

fun dummyData(): ArrayList<EnglishDataClass> {
    val list = ArrayList<EnglishDataClass>()
    list.add(EnglishDataClass("word1"))
    list.add(EnglishDataClass("word2"))
    list.add(EnglishDataClass("word3"))
    list.add(EnglishDataClass("word4"))
    return list
}