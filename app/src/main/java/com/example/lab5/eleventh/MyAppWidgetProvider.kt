package com.example.lab5.eleventh

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.RemoteViews
import com.example.lab5.R


class MyAppWidgetProvider : AppWidgetProvider() {

    private companion object {
        const val ADD_BUTTON_CLICKED = "addButtonClicked"
        const val CLEAR_BUTTON_CLICKED = "clearButtonClicked"
        const val NAME = "NAME"
        const val COUNT_CLICKS = "countClicks"
    }

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    )
    {

        val data = context!!.getSharedPreferences(NAME, 0)
        val editor: SharedPreferences.Editor = data.edit()
        editor.putInt(COUNT_CLICKS, 0)
        editor.commit()

        appWidgetIds?.forEach { appWidgetId ->
            val remoteViews = RemoteViews(
                context?.packageName,
                R.layout.widget_layout
            )
            val intentAdd = Intent(context, MyAppWidgetProvider::class.java).apply {
                action = ADD_BUTTON_CLICKED
            }
            val intentClear = Intent(context, MyAppWidgetProvider::class.java).apply {
                action = CLEAR_BUTTON_CLICKED
            }
            val pendingIntentAdd =
                PendingIntent.getBroadcast(context, 0, intentAdd, PendingIntent.FLAG_MUTABLE)
            val pendingIntentClear =
                PendingIntent.getBroadcast(context, 0, intentClear, PendingIntent.FLAG_MUTABLE)
            remoteViews.setOnClickPendingIntent(R.id.bnAddCounter, pendingIntentAdd)
            remoteViews.setOnClickPendingIntent(R.id.bnClearCounter, pendingIntentClear)
            appWidgetManager?.updateAppWidget(appWidgetId, remoteViews)
        }

    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        var remoteViews = RemoteViews(
            context?.packageName,
            R.layout.widget_layout
        )
        if(intent?.action == ADD_BUTTON_CLICKED) {
            val data = context!!.getSharedPreferences(NAME, 0)
            val countClicks = data.getInt(COUNT_CLICKS, 0) + 1
            val editor: SharedPreferences.Editor = data.edit()
            editor.putInt(COUNT_CLICKS, countClicks)
            editor.commit()
            remoteViews.setTextViewText(R.id.tvCounter, countClicks.toString())
        } else if(intent?.action == CLEAR_BUTTON_CLICKED) {
            val data = context!!.getSharedPreferences(NAME, 0)
            val editor: SharedPreferences.Editor = data.edit()
            editor.putInt(COUNT_CLICKS, 0)
            editor.commit()
            remoteViews.setTextViewText(R.id.tvCounter, "0")
        }
        val watchWidget = ComponentName(context!!, MyAppWidgetProvider::class.java)
        AppWidgetManager.getInstance(context).updateAppWidget(watchWidget, remoteViews)

    }


}