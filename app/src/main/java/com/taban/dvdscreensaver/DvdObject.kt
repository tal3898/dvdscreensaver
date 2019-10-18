package com.taban.dvdscreensaver

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*

class DvdObject(_resources: Resources, _screenWidth: Int, _screenHeight: Int) {

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
        imgWidth = 500
        imgHeight = 350
        screenHeight = _screenHeight
        screenWidth = _screenWidth
        colorsMap = DvdImagesMap(_resources)
    }

    /**
     * the method move the dvd object forward. If it touches the wall, change the directions
     */
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