package com.upc.projects.enzoftware.eventour.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.upc.projects.enzoftware.eventour.model.Event

class EventApi {
    companion object {
        val base_url = "https://eventour-api.herokuapp.com/api"
        val eventsUrl = "$base_url/events"
        val organizersUrl = "$base_url/organizers"
        val tag = "EvenTour"

        fun requesEvents(responseHandler:(List<Event>) -> Unit, errorHandler:(ANError) -> Unit){
            AndroidNetworking.get(EventApi.eventsUrl)
                    .setPriority(Priority.MEDIUM)
                    .setTag(EventApi.tag)
                    .build()
                    .getAsObjectList(Event::class.java, object:ParsedRequestListener<List<Event>>{
                        override fun onResponse(response: List<Event>?) {
                            responseHandler(response!!)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError!!)
                        }
                    })
        }
    }

}