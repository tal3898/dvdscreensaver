package com.taban.dvdscreensaver

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.view.MotionEvent
import java.util.*
import android.view.SurfaceHolder
import android.view.SurfaceView


class GameView(context : Context) : SurfaceView(context) , Runnable{


    val paint :Paint
    val dvd : DvdObject
    val ourHolder: SurfaceHolder
    var isMoving : Boolean = true
    var gameThread : Thread

    init {
        paint = Paint()
        paint.isFilterBitmap = true
        paint.isAntiAlias = true
        paint.color = Color.YELLOW
        dvd = DvdObject(resources);
        ourHolder = holder
        gameThread = Thread(this)
    }

    public fun resume() {
        gameThread = Thread(this)
        gameThread.start()
    }

    public fun pause() {
        try {
            gameThread.join()
        } catch (e : Exception) {
            println("error in joining the thread")
        }
    }

    override fun run() {
        while (true) {
            if (ourHolder.surface.isValid && isMoving) {
                var canvas = ourHolder.lockCanvas()
                dvd.moveForward()
                canvas.drawColor(Color.YELLOW)
                canvas.drawBitmap(dvd.getImage(), dvd.posx, dvd.posy, paint)
                ourHolder.unlockCanvasAndPost(canvas)
            } else {
                println("tal in else")
            }
        }
    }

}