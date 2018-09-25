package com.upc.projects.enzoftware.eventour.model

data class Event(
        val id : Int?,
        val urlImage: String?,
        val event_name: String?,
        val startDate: String?,
        val endDate: String?,
        val duration: Int?,
        val createdAt: String?,
        val updatedAt: String?,
        val event_id: Integer?
){}