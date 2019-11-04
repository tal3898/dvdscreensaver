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
    var isMoving : Boolean

    init {
        paint = Paint()
        paint.isFilterBitmap = true
        paint.isAntiAlias = true
        paint.color = Color.YELLOW
        dvd = DvdObject(resources, _screenWidth, _screenHeight)
        ourHolder = holder
        gameThread = Thread(this)
        isMoving = true
    }

    override fun run() {
        while (isMoving) {
            if (ourHolder.surface.isValid) {
                var canvas = ourHolder.lockCanvas()
                if (canvas != null) {
                    dvd.moveForward()
                    canvas.drawColor(Color.BLACK)
                    canvas.drawBitmap(dvd.getImage(), dvd.posx, dvd.posy, paint)
                    ourHolder.unlockCanvasAndPost(canvas)
                }
            } else {
                Log.w(MainActivity.LOG_TAG, "The holder surface is not valid")
            }
        }
    }

    fun resume() {
        isMoving = true
        gameThread = Thread(this)
        gameThread.start()
    }

    fun pause() {
        try {
            isMoving = false
            gameThread.join()
            Log.i(MainActivity.LOG_TAG, "paused successfully")
        } catch (e : Exception) {
            Log.e(MainActivity.LOG_TAG, "Could not stop the thread")
        }
    }
}