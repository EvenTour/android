package com.upc.projects.enzoftware.eventour.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.eventour.model.Organizer
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.organizer_item.view.*

class OrganizerAdapter(val context: Context, var OrganizerList: ArrayList<Organizer>):RecyclerView.Adapter<OrganizerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.organizer_item, parent, false))
    }

    override fun getItemCount(): Int {
        return OrganizerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val organizer = OrganizerList[position]
        holder.UpdateFrom(organizer)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val itemLayout = view.OrganizerItem
        val organizerImageView = view.organizerImage
        val organizerTextView = view.organizerName

        fun UpdateFrom(organizer:Organizer){
            organizerImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            organizerImageView.setErrorImageResId(R.mipmap.ic_launcher)
            organizerImageView.setImageUrl(organizer.urlImage)

            organizerTextView.text = organizer.name

        }
    }

}