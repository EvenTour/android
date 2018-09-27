package com.upc.projects.enzoftware.eventour.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError

import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Event
import com.upc.projects.enzoftware.eventour.network.EvenTourApi
import com.upc.projects.enzoftware.eventour.ui.adapters.EventAdapter

class EventFragment : Fragment() {

    var Events:ArrayList<Event> = ArrayList()
    lateinit var EventRecyclerView:RecyclerView
    lateinit var EventAdapter:EventAdapter
    lateinit var EventManager:RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_event, container, false)

        EventRecyclerView = view.findViewById(R.id.eventRecyclerView)
        EventAdapter = EventAdapter(view.context,Events)
        EventManager = GridLayoutManager(view.context,1) as RecyclerView.LayoutManager

        EventRecyclerView.layoutManager = EventManager
        EventRecyclerView.adapter = EventAdapter

        EvenTourApi.requesEvents(
                {response -> ResponseHandler(response)},
                {anError -> ErrorHandler(anError) })

        return  view
    }


    fun ResponseHandler(EventsList: List<Event>){
        this.Events = ArrayList(EventsList)
        EventAdapter.EventList = this.Events
        EventAdapter.notifyDataSetChanged()
    }

    fun ErrorHandler(anError: ANError){
        Log.e("Error charging events", anError.message)
    }


}
