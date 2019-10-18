package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Size
import java.util.*

class DvdObject(_resources: Resources, _screenWidth: Int, _screenHeight: Int) {

    companion object {
        var DVD_WIDTH : Int = 0
        var DVD_HEIGHT : Int = 0
        lateinit var DVD_SIZE : Size
    }

    var currColor : Color = Color.BLUE
    var posx : Float = 0f
    var posy : Float = 0f
    var dirx : Int = 1
    var diry : Int = 1
    val speed : Int = 5
    val screenWidth : Int
    val screenHeight : Int
    val colorsMap : DvdImagesMap


    init {
        screenHeight = _screenHeight
        screenWidth = _screenWidth
        colorsMap = DvdImagesMap(_resources)
    }

    /**
     * the method move the dvd object forward. If it touches the wall, change the directions
     */
    fun moveForward() {
        if (posx.toInt() + DVD_WIDTH > screenWidth ||
                posx < 0) {
            dirx *= -1
            changeDvdColor()
        }
        if (posy.toInt() + DVD_HEIGHT > screenHeight ||
                posy < 0) {
            diry *= -1
            changeDvdColor()
        }
        posx += speed * dirx
        posy += speed * diry
    }

    /**
     * get the dvd image according to the current dvd color
     */
    fun getImage() : Bitmap {
        return colorsMap.getColorImage(currColor)
    }

    /**
     * the method change the color of the dvd object randomly
     */
    private fun changeDvdColor() {
        val colorsAsList = Color.values()
        var randomColorIndex = Random().nextInt(colorsAsList.size)
        if (colorsAsList.get(randomColorIndex).equals(currColor)) {
            randomColorIndex = (randomColorIndex + 1) % colorsAsList.size
        }

        currColor = colorsAsList.get(randomColorIndex)
    }
}