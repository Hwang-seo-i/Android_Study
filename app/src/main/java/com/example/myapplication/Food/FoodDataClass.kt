package com.example.myapplication.Food

class FoodDataClass(
    var name: String)

fun dummyData(): ArrayList<FoodDataClass> {
    val Foodlist = ArrayList<FoodDataClass>()
    Foodlist.add(FoodDataClass("시나모롤"))
    Foodlist.add(FoodDataClass("폼폼푸린"))
    Foodlist.add(FoodDataClass("쿠로미"))
    Foodlist.add(FoodDataClass("포차코"))
    return Foodlist
}

