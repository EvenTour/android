package com.upc.projects.enzoftware.eventour.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.eventour.model.Event
import kotlinx.android.synthetic.main.event_item.view.*

class EventAdapter(val context: Context, var EventList: ArrayList<Event>):RecyclerView.Adapter<EventAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return EventList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val itemLayout = view.EventItem
        val eventImageView = view.eventImage
        val eventNameView = view.eventName

        fun UpdateFrom(event:Event){
            eventImageView.setDefaultImageResId(R.mipmap.ic_launcher)

        }


    }

}