package com.upc.projects.enzoftware.eventour.model

import android.os.Bundle

data class Organizer(
        val id:Int?,
        val urlImage:String?,
        val name:String?,
        val contactUrl:String?,
        val field:String?,
        val event_id:Int?,
        val createdAt:String?,
        val updatedAt:String?
){
    companion object {
        fun from(bundle: Bundle):Organizer{
            val organizer = Organizer(
                    bundle.getInt("id"),
                    bundle.getString("urlImage"),
                    bundle.getString("name"),
                    bundle.getString("contactUrl"),
                    bundle.getString("field"),
                    bundle.getInt("event_id"),
                    bundle.getString("createdAt"),
                    bundle.getString("updatedAt")
            )
            return organizer
        }
    }

    fun toBundle():Bundle{
        val bundle = Bundle()

        with(bundle){
            putInt("id", id!!)
            putString("urlImage", urlImage!!)
            putString("name", name!!)
            putString("contactUrl", contactUrl!!)
            putString("field", field!!)
            putInt("event_id", event_id!!)
            putString("createdAt", createdAt!!)
            putString("updatedAt", updatedAt!!)
        }

        return bundle
    }
}