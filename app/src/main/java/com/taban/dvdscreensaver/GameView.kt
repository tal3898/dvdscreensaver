package com.taban.dvdscreensaver

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView


class GameView(_context: Context, _screenHeight: Int, _screenWidth: Int) : SurfaceView(_context) , Runnable{

    val paint :Paint
    val dvd : DvdObject
    val ourHolder: SurfaceHolder
    var gameThread : Thread

    init {
        paint = Paint()
        paint.isFilterBitmap = true
        paint.isAntiAlias = true
        paint.color = Color.YELLOW
        dvd = DvdObject(resources, _screenWidth, _screenHeight)
        ourHolder = holder
        gameThread = Thread(this)
    }

    override fun run() {
        while (true) {
            if (ourHolder.surface.isValid) {
                var canvas = ourHolder.lockCanvas()
                dvd.moveForward()
                canvas.drawColor(Color.BLACK)
                canvas.drawBitmap(dvd.getImage(), dvd.posx, dvd.posy, paint)
                ourHolder.unlockCanvasAndPost(canvas)
            }
        }
    }

    fun resume() {
        Log.i(MainActivity.LOG_TAG, "resuming the dvd")
        gameThread = Thread(this)
        gameThread.start()
    }

    fun pause() {
        Log.i(MainActivity.LOG_TAG, "pausing the dvd")
        try {
            gameThread.join()
        } catch (e : Exception) {
            Log.e(MainActivity.LOG_TAG, "Could not stop the thread")
        }
    }
}