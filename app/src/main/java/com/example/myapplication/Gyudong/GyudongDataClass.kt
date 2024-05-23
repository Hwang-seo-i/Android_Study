package com.example.myapplication.Gyudong

class GyuDataClass(
    var name: String)

fun dummyData(): ArrayList<GyuDataClass> {
    val GyuList = ArrayList<GyuDataClass>()
    GyuList.add(GyuDataClass("시나모롤"))
    GyuList.add(GyuDataClass("폼폼푸린"))
    GyuList.add(GyuDataClass("쿠로미"))
    GyuList.add(GyuDataClass("포차코"))
    return GyuList
}

