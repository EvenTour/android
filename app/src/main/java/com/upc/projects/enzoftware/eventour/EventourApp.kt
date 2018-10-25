package com.upc.projects.enzoftware.eventour

import com.androidnetworking.AndroidNetworking
import com.orm.SugarApp

class EventourApp :SugarApp() {

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext())
    }

}