package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import java.util.*

class DvdObject(resources: Resources) {

    val originalImage : Bitmap
    val resizedImage : Bitmap
    var posx : Float = 0f
    var posy : Float = 0f
    var dirx : Int = 1
    var diry : Int = 1
    val speed : Int = 5

    public fun moveForward() {
        posx += speed * dirx
        posy += speed * diry
    }

    public fun getImage() : Bitmap {
        return resizedImage
    }




    init {
        originalImage = BitmapFactory.decodeResource(resources, R.drawable.dvd_black)
        resizedImage = resizeBitmap(originalImage, 500, 350)

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

}