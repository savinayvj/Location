package com.app.location

class Model(lat : String, long:String){

    var latitude : String;
    var longitude: String;
    init{

        latitude = lat;
        longitude = long;


    }

    fun getLat() : String{
        return latitude;

    }

    fun getLong():String{
        return longitude;

    }

    fun setLat(lat:String){
        latitude = lat;

    }
    fun setLong(long:String){
        longitude = long;

    }





}