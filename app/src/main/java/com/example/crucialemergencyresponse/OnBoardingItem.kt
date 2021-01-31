package com.example.crucialemergencyresponse

data class OnBoardingItem(
        var image : Int,
        var title : String,
        var description : String
        ){

        constructor() : this(0,"","")
}