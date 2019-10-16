package com.taban.dvdscreensaver

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.graphics.BitmapFactory
import android.graphics.Bitmap



class GameView(context : Context) : View(context) {

    val paint :Paint
    val originalDvdImage : Bitmap
    val resizedDvdImage : Bitmap

    init {
        paint = Paint()
        paint.isFilterBitmap = true
        paint.isAntiAlias = true
        paint.color = Color.YELLOW
        originalDvdImage = BitmapFactory.decodeResource(resources, R.drawable.dvd_black)
        resizedDvdImage = resizeBitmap(originalDvdImage, 500, 350);
    }

    private fun resizeBitmap(bitmap:Bitmap, width:Int, height:Int):Bitmap{
        /*
            *** reference source developer.android.com ***
            Bitmap createScaledBitmap (Bitmap src, int dstWidth, int dstHeight, boolean filter)
                Creates a new bitmap, scaled from an existing bitmap, when possible. If the specified
                width and height are the same as the current width and height of the source bitmap,
                the source bitmap is returned and no new bitmap is created.

            Parameters
                src Bitmap : The source bitmap.
                    This value must never be null.

            dstWidth int : The new bitmap's desired width.
            dstHeight int : The new bitmap's desired height.
            filter boolean : true if the source should be filtered.

            Returns
                Bitmap : The new scaled bitmap or the source bitmap if no scaling is required.

            Throws
                IllegalArgumentException : if width is <= 0, or height is <= 0
        */
        return Bitmap.createScaledBitmap(
                bitmap,
                width,
                height,
                false
        )
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        canvas?.drawColor(Color.RED)
        canvas?.drawBitmap(resizedDvdImage, 40f, 40f, paint)



    }
}