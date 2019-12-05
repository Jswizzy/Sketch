package com.arrowmaker.sketch

import processing.core.PApplet

class Sketch : PApplet() {
    override fun setup() {
        mouseX = width/2
        mouseY = height/2
    }

    override fun draw() {
        line(width/2f, height/2f, mouseX.toFloat(), mouseY.toFloat())
    }
}