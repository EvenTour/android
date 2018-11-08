package com.upc.projects.enzoftware.eventour.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Message
import com.upc.projects.enzoftware.eventour.ui.adapters.MessageAdapter

import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    var MessageList:ArrayList<Message> = ArrayList()
    lateinit var MessageRecyclerView: RecyclerView
    lateinit var MessageAdapter:MessageAdapter
    lateinit var MessageManager:RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl(getString(R.string.database_reference))
        MessageRecyclerView = findViewById(R.id.recyclerViewMessages)
        MessageAdapter = MessageAdapter(this, MessageList)
        MessageManager = GridLayoutManager(this,1)

        MessageRecyclerView.adapter = MessageAdapter
        MessageRecyclerView.layoutManager = MessageManager

        val btnSend = findViewById<Button>(R.id.chatSendButton)
        btnSend.setOnClickListener {

            val chatMessage = findViewById<TextView>(R.id.chatMessage)
            val sdf = SimpleDateFormat("HH:mm a")
            val currentTime = sdf.format(Calendar.getInstance().time)

            val message = Message(chatMessage.text.toString(),"User name",
                    " ", "text", currentTime)

            MessageAdapter.addMessage(message)
            mDatabase.child("chat").push().setValue(message)
            chatMessage.text = ""
        }

        MessageAdapter.registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver(){
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                setScrollbar()
            }
        })

        mDatabase.child("chat").addChildEventListener(object: ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val m = p0.getValue(Message::class.java)
                MessageAdapter.addMessage(m!!)
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }

        })
    }

    private fun setScrollbar(){
        MessageRecyclerView.scrollToPosition(MessageAdapter.itemCount - 1)
    }

}
