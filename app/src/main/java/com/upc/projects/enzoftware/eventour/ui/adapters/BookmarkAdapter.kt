package com.upc.projects.enzoftware.eventour.ui.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Bookmark
import com.upc.projects.enzoftware.eventour.model.Event
import com.upc.projects.enzoftware.eventour.ui.activities.EventActivity
import kotlinx.android.synthetic.main.event_item.view.*

class BookmarkAdapter(val context: Context, var EventList: ArrayList<Bookmark>): RecyclerView.Adapter<BookmarkAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_item, parent, false))
    }

    override fun getItemCount(): Int {
        return EventList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = EventList[position]
        holder.UpdateFrom(event)
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemLayout = view.EventItem
        val eventImageView = view.eventImage
        val eventNameView = view.eventName

        fun UpdateFrom(event: Bookmark){
            eventImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            eventImageView.setErrorImageResId(R.mipmap.ic_launcher)
            eventImageView.setImageUrl(event.urlImage)

            eventNameView.text = event.eventName

            itemLayout.setOnClickListener{view ->
                val context = view.context
                context.startActivity(Intent(context, EventActivity::class.java)
                        .putExtras(event.toBundle()))

            }
        }
    }

}