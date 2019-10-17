package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class DvdImagesMap(_resources : Resources) {
    var colorsMap : HashMap<Color, Bitmap>
    val imgWidth : Int
    val imgHeight : Int

    init  {
        colorsMap = HashMap()
        imgWidth = 500
        imgHeight = 350

        colorsMap.put(Color.AZURE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_azure), imgWidth, imgHeight))
        colorsMap.put(Color.BLUE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_blue), imgWidth, imgHeight))
        colorsMap.put(Color.GREEN,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_green), imgWidth, imgHeight))
        colorsMap.put(Color.ORANGE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_orange), imgWidth, imgHeight))
        colorsMap.put(Color.PINK,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_pink), imgWidth, imgHeight))
        colorsMap.put(Color.PURPLE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_purple), imgWidth, imgHeight))
        colorsMap.put(Color.RED,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_red), imgWidth, imgHeight))
        colorsMap.put(Color.YELLOW,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_yellow), imgWidth, imgHeight))


    }

    fun getColorImage(color : Color) : Bitmap {
        return colorsMap.get(color)!!
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