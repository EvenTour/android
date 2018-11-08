package com.upc.projects.enzoftware.eventour.model

data class Message(
        val message:String? = "",
        val userName:String? = "",
        val userPhoto:String? = "",
        val typeMessage:String? = "",
        val messageTime:String? = ""
)