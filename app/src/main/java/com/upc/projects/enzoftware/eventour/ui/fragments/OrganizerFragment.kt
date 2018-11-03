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
import com.upc.projects.enzoftware.eventour.model.Organizer
import com.upc.projects.enzoftware.eventour.network.EvenTourApi
import com.upc.projects.enzoftware.eventour.ui.adapters.OrganizerAdapter
import kotlinx.android.synthetic.main.fragment_organizer.*


class OrganizerFragment : Fragment() {

    var Organizers:ArrayList<Organizer> = ArrayList()
    lateinit var OrganizerRecyclerView:RecyclerView
    lateinit var OrganizerAdapter:OrganizerAdapter
    lateinit var OrganizerManager:RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_organizer, container, false)

        OrganizerRecyclerView = view.findViewById(R.id.organizerRecyclerView)
        OrganizerAdapter = OrganizerAdapter(view.context,Organizers)
        OrganizerManager = GridLayoutManager(view.context, 2)

        OrganizerRecyclerView.adapter = OrganizerAdapter
        OrganizerRecyclerView.layoutManager = OrganizerManager

        EvenTourApi.requesOrganizers(
                {response -> ResponseHandler(response)},
                {anError -> ErrorHandler(anError)}
        )

        return view
    }

    fun ResponseHandler(OrganizerList: List<Organizer>){
        this.Organizers = ArrayList(OrganizerList)
        OrganizerAdapter.OrganizerList = this.Organizers
        OrganizerAdapter.notifyDataSetChanged()
    }

    fun ErrorHandler(anError: ANError){
        Log.e("Error charging events", anError.message)
    }

}
