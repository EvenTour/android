package com.upc.projects.enzoftware.eventour.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager{

    lateinit var preferences : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    lateinit var context : Context

    var PRIVATE_MODE = 0

    val PREF_NAME = "eventour-welcome"
    val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"

    constructor(context: Context){
        this.context = context
        preferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        editor = preferences.edit()
    }

    fun setFirstTimeLaunch(isFirstTime : Boolean){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch() : Boolean = preferences.getBoolean(IS_FIRST_TIME_LAUNCH,true)

}