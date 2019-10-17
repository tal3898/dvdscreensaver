package com.taban.dvdscreensaver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.util.DisplayMetrics



class MainActivity : AppCompatActivity() {

    lateinit var gameView : GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        gameView = GameView(this, height, width)
        setContentView(gameView)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gameView.isMoving = !gameView.isMoving
        return super.onTouchEvent(event)
    }

    override fun onResume() {
        super.onResume()
        gameView.resume()
    }

    override fun onPause() {
        super.onPause()
        gameView.pause()
    }
}
