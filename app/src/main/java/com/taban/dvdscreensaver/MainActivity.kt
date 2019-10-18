package com.taban.dvdscreensaver

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.util.DisplayMetrics
import android.util.Size
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import android.R.attr.orientation
import android.content.res.Configuration
import android.util.Log


class MainActivity : Activity() {

    companion object {
        val LOG_TAG : String = "dvd_log"
    }

    lateinit var gameView : GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide both the navigation bar and the status bar.
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        initGameView()

        setContentView(gameView)
    }

    override fun onResume() {
        super.onResume()
        gameView.resume()
    }

    override fun onPause() {
        super.onPause()
        gameView.pause()
    }

    private fun initGameView() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        if (height > width) {
            DvdObject.DVD_WIDTH = width / 2
            DvdObject.DVD_HEIGHT = height / 6
        } else {
            DvdObject.DVD_WIDTH = height / 2
            DvdObject.DVD_HEIGHT = width / 6
        }

        gameView = GameView(this, height, width)
    }
}
