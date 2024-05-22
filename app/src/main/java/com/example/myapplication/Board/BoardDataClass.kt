package com.example.myapplication.Board

data class BoardDataClass(
    val number: Int,
    var title: String,
    var date: String
)

fun dummyData(): ArrayList<BoardDataClass> {
    val list = ArrayList<BoardDataClass>()
    list.add(BoardDataClass(1, "title1", "2021-09-01"))
    list.add(BoardDataClass(2, "title2", "2021-09-02"))
    list.add(BoardDataClass(3, "title3", "2021-09-03"))
    list.add(BoardDataClass(4, "title4", "2021-09-04"))
    return list
}
