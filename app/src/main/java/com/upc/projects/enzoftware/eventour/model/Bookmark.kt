package com.upc.projects.enzoftware.eventour.model

import android.os.Bundle
import com.orm.SugarRecord

class Bookmark() : SugarRecord() {
    var eventId: String? = null

    var urlImage: String? = null
    var eventName: String? = null
    var startDate: String? = null
    var endDate: String? = null
    var duration: String? = null
    var createdTime: String? = null
    var updatedTime: String? = null

    fun toBundle(): Bundle {
        val bundle = Bundle()

        with(bundle){
            putString("id", eventId!!)
            putString("urlImage", urlImage!!)
            putString("event_name", eventName!!)
            putString("startDate", startDate!!)
            putString("endDate", endDate!!)
            putString("duration", duration!!)
            putString("createdAt", createdTime!!)
            putString("updatedAt", updatedTime!!)

        }

        return bundle
    }


    companion object {
        fun eventosIdsAsString(): String {
            return SugarRecord.listAll(Bookmark::class.java)
                    .joinToString { bookmark ->
                        bookmark.eventId!!
                    }
        }

        fun listAll(): List<Bookmark> {
            return SugarRecord.listAll(Bookmark::class.java)
        }

        fun alistAll(): ArrayList<Bookmark> {

            return ArrayList(SugarRecord.listAll(Bookmark::class.java))
        }

        fun listFor(eventId: String): List<Bookmark> {
            return SugarRecord.find(Bookmark::class.java,
                    "event_id = ? ", eventId)
        }
    }



}