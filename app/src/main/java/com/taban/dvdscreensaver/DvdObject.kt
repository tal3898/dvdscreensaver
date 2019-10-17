package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*

class DvdObject(_resources: Resources, _screenWidth: Int, _screenHeight: Int) {

    //val originalImage : Bitmap
    //val resizedImage : Bitmap
    var currColor : Color = Color.BLUE
    var posx : Float = 0f
    var posy : Float = 0f
    var dirx : Int = 1
    var diry : Int = 1
    val speed : Int = 5
    val imgWidth : Int
    val imgHeight : Int
    val screenWidth : Int
    val screenHeight : Int
    val colorsMap : DvdImagesMap


    init {
        //originalImage = BitmapFactory.decodeResource(_resources, R.drawable.dvd_black)
        imgWidth = 500
        imgHeight = 350
        //resizedImage = resizeBitmap(originalImage, imgWidth, imgHeight)
        screenHeight = _screenHeight
        screenWidth = _screenWidth
        colorsMap = DvdImagesMap(_resources)
    }


    fun moveForward() {
        if (posx.toInt() + this.imgWidth > screenWidth ||
                posx < 0) {
            dirx *= -1
            changeDvdColor()
        }
        if (posy.toInt() + this.imgHeight > screenHeight ||
                posy < 0) {
            diry *= -1
            changeDvdColor()
        }
        posx += speed * dirx
        posy += speed * diry
    }

    fun getImage() : Bitmap {
        return colorsMap.getColorImage(currColor)
    }

    fun changeDvdColor() {
        val colorsAsList = Color.values()
        var randomColorIndex = Random().nextInt(colorsAsList.size)
        if (colorsAsList.get(randomColorIndex).equals(currColor)) {
            randomColorIndex = (randomColorIndex + 1) % colorsAsList.size
        }

        currColor = colorsAsList.get(randomColorIndex)
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