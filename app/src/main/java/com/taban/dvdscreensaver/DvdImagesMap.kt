package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class DvdImagesMap(_resources : Resources) {
    var colorsMap : HashMap<Color, Bitmap>

    init  {
        colorsMap = HashMap()
        
        colorsMap.put(Color.AZURE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_azure), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.BLUE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_blue), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.GREEN,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_green), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.ORANGE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_orange), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.PINK,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_pink), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.PURPLE,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_purple), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.RED,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_red), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))
        colorsMap.put(Color.YELLOW,
                resizeBitmap(BitmapFactory.decodeResource(_resources, R.drawable.dvd_yellow), DvdObject.DVD_WIDTH, DvdObject.DVD_HEIGHT))


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