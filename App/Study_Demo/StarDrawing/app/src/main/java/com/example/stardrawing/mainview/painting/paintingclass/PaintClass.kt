package com.example.stardrawing.mainview.painting.paintingclass

import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Xfermode

class PaintClass constructor(sizeInit: Int, canvasInit: Int, colorAlter: Int) {

    //拉取画笔实例
    private val paintAlter: Paint = Paint()

    //设置画笔与橡皮擦模式的笔刷宽度
    private var paintSize: Int
    private var eraseSize: Int

    //设置画笔的模式
    private var paintMode: PaintMode = PaintMode.PaintMode


    //当画笔转为橡皮檫模式时，将此值赋到画笔上
    private var paintEraseXferMode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    //画笔所在画布的底色和画笔的颜色，橡皮擦运用了画布底色，不能更改，画笔的颜色可更改
    private val canvasColor: Int
    private var paintColor: Int

    //主构造方法将实现画笔的颜色，画布的颜色，其余值默认
    init {
        paintColor = colorAlter
        paintSize = sizeInit
        paintAlter.color = paintColor
        paintAlter.strokeWidth = paintSize.toFloat()
        eraseSize = 20
        this.canvasColor = canvasInit

        setBaseInfo()
    }

    fun getPaint() = paintAlter

    private fun setBaseInfo() {
        //画笔抗锯齿
        paintAlter.isAntiAlias = true
        paintAlter.isDither = true
        paintAlter.isFilterBitmap = true

        //风格，默认描边
        paintAlter.style = Paint.Style.STROKE

        //其他属性设置
        paintAlter.strokeJoin = Paint.Join.ROUND
        paintAlter.strokeCap = Paint.Cap.ROUND
        paintAlter.pathEffect = CornerPathEffect(50f)

    }

    /**************画笔颜色更改与拉取***************/
    fun reSetPaintColor(colorAlter: Int) {
        paintColor = colorAlter
        if (paintMode == PaintMode.PaintMode) {
            paintAlter.color = paintColor
        }
    }

    fun getPaintColor() = paintColor
    /*****************************/

    /*************画笔大小更改与拉取****************/
    fun reSetPaintSize(sizeAlter: Int) {
        paintSize = sizeAlter
        if (paintMode == PaintMode.PaintMode) {
            paintAlter.strokeWidth = paintSize.toFloat()
        }
    }

    fun getPaintSize() = paintSize
    /*****************************/

    /*************橡皮擦大小更改****************/
    fun reSetEraseSize(sizeAlter: Int) {
        eraseSize = sizeAlter
        if (paintMode == PaintMode.EraseMode) {
            paintAlter.strokeWidth = eraseSize.toFloat()
        }
    }

    /*****************************/

    //fun:设置画笔的模式:绘画模式和橡皮擦模式
    fun reSetPaintMode(mode: PaintMode) {
        paintMode = mode

        if (paintMode == PaintMode.PaintMode) {
            paintAlter.strokeWidth = paintSize.toFloat()
            paintAlter.xfermode = null
            paintAlter.color = paintColor
        }
        if (paintMode == PaintMode.EraseMode) {
            paintAlter.strokeWidth = eraseSize.toFloat()
            paintAlter.xfermode = paintEraseXferMode
            paintAlter.color = canvasColor
        }

    }

    //fun:拉取该画笔的模式
    fun getPaintMode() = paintMode


}