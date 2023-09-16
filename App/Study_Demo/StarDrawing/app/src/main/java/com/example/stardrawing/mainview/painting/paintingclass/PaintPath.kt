package com.example.stardrawing.mainview.painting.paintingclass

import android.graphics.Paint
import android.graphics.Path

class PaintPath(paint: Paint,path: Path) {

    private var paint:Paint
    private var path: Path

    init {
        this.paint=paint
        this.path=path
    }

    public fun getPath() = path

    public fun getPaint() = paint

    public fun setPath(path: Path){
        this.path=path
    }

    public fun setPaint(paint: Paint){
        this.paint=paint
    }

}