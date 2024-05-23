package com.example.myapplication.Dog

data class DogDataClass(
    var name: String
)
fun dummyData(): ArrayList<DogDataClass> {
    val Doglist = ArrayList<DogDataClass>()
    Doglist.add(DogDataClass("말티즈"))
    Doglist.add(DogDataClass("비숑"))
    Doglist.add(DogDataClass("푸들"))
    return Doglist
}