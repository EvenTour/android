package com.upc.projects.enzoftware.eventour.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Message
import kotlinx.android.synthetic.main.card_view_message.view.*

class MessageAdapter(val context: Context, var MessageList: ArrayList<Message>)
    :RecyclerView.Adapter<MessageAdapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapter.ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view_message, parent,false))
        }

        override fun getItemCount(): Int {
            return MessageList.size
        }

        override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) {
            val message = MessageList[position]
            holder.UpdateFrom(message)
        }

        fun addMessage(message: Message) {
            MessageList.add(message)
            notifyDataSetChanged()
        }

        class ViewHolder(view: View):RecyclerView.ViewHolder(view){

            val messageView = view.cardMessage
            val timeView = view.cardMessageTime
            val userNameView = view.cardUserName
            val userImageView = view.cardUserImage

            fun UpdateFrom(message: Message){
                messageView.text = message.message
                timeView.text = message.messageTime
                userNameView.text = message.userName
            }
        }
    }