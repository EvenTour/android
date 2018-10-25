package com.upc.projects.enzoftware.eventour.model

import android.os.Bundle

data class Event(
        val id : Int?,
        val urlImage: String?,
        val event_name: String?,
        val startDate: String?,
        val endDate: String?,
        val duration: Int?,
        val createdAt: String?,
        val updatedAt: String?,
        val event_id: Int?
){
    companion object {
        fun from(bundle: Bundle):Event{
            val event = Event(
                    bundle.getInt("id"),
                    bundle.getString("urlImage"),
                    bundle.getString("event_name"),
                    bundle.getString("startDate"),
                    bundle.getString("endDate"),
                    bundle.getInt("duration"),
                    bundle.getString("createdAt"),
                    bundle.getString("updatedAt"),
                    bundle.getInt("event_id")
            )
            return event
        }
    }

    fun toBundle():Bundle{
        val bundle = Bundle()

        with(bundle){
            putInt("id", id!!)
            putString("urlImage", urlImage!!)
            putString("event_name", event_name!!)
            putString("startDate", startDate!!)
            putString("endDate", endDate!!)
            putInt("duration", duration!!)
            putString("createdAt", createdAt!!)
            putString("updatedAt", updatedAt!!)
            putInt("event_id", 0)
        }

        return bundle
    }

    fun isBookmarked() : Boolean {
        return Bookmark.listFor(Integer.toString(id!!)).isNotEmpty()
    }

    fun setBookmarked(isBookmarked: Boolean) {
        if (isBookmarked == isBookmarked()) {
            return
        }
        if (isBookmarked) {
            val bookmark = Bookmark()
            bookmark.eventId = Integer.toString(id!!)
            bookmark.urlImage =urlImage
            bookmark.eventName =event_name
            bookmark.startDate=startDate
            bookmark.endDate=endDate
            bookmark.duration= Integer.toString(duration!!)
            bookmark.createdTime=createdAt
            bookmark.updatedTime=updatedAt



            bookmark.save()
        } else {
            Bookmark.listFor(Integer.toString(id!!)).map { bookmark ->
                bookmark.delete()  }
        }

    }

}