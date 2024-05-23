package com.example.myapplication.Korean

data class CharacterDataClass(
    var name: String
)

fun dummyData(): ArrayList<CharacterDataClass> {
    val Characterlist = ArrayList<CharacterDataClass>()
    Characterlist.add(CharacterDataClass("시나모롤"))
    Characterlist.add(CharacterDataClass("폼폼푸린"))
    Characterlist.add(CharacterDataClass("쿠로미"))
    Characterlist.add(CharacterDataClass("포차코"))
    Characterlist.add(CharacterDataClass("헬로키티"))
    return Characterlist
}