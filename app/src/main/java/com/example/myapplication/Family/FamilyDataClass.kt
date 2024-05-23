package com.example.myapplication.Family

class FamilyDataClass(
    var name: String
)
fun dummyData(): ArrayList<FamilyDataClass> {
    val familyList = ArrayList<FamilyDataClass>()
    familyList.add(FamilyDataClass("아빠"))
    familyList.add(FamilyDataClass("엄마"))
    familyList.add(FamilyDataClass("동생"))
    return familyList
}
