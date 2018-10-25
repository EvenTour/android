package com.upc.projects.enzoftware.eventour.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Bookmark
import com.upc.projects.enzoftware.eventour.ui.adapters.BookmarkAdapter
import kotlinx.android.synthetic.main.fragment_event_favorites.view.*

class FavoriteFragment : Fragment() {



    var Events:ArrayList<Bookmark> = ArrayList()
    lateinit var EventRecyclerView: RecyclerView
    lateinit var BookmarkAdapter: BookmarkAdapter
    lateinit var EventManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (Bookmark.eventosIdsAsString().isEmpty()) {
            return inflater.inflate(R.layout.fragment_event_favorites_unselected, container, false)
        }


        val view = inflater.inflate(R.layout.fragment_event_favorites, container, false)


        BookmarkAdapter = BookmarkAdapter(view.context,Events)
        EventManager = GridLayoutManager(view.context,1) as RecyclerView.LayoutManager

        EventRecyclerView = view.eventsRecyclerView

        EventRecyclerView.layoutManager = EventManager
        EventRecyclerView.adapter = BookmarkAdapter


        this.Events = Bookmark.alistAll()
        BookmarkAdapter.EventList = this.Events
        BookmarkAdapter.notifyDataSetChanged()


        /*EvenTourApi.requesEvents(
                {response -> ResponseHandler(response)},
                {anError -> ErrorHandler(anError) })*/

        return  view
    }


   /* fun ResponseHandler(EventsList: List<Event>){
        this.Events = ArrayList(EventsList)
        EventAdapter.EventList = this.Events
        EventAdapter.notifyDataSetChanged()
    }

    fun ErrorHandler(anError: ANError){
        Log.e("Error charging events", anError.message)
    }*/

}
