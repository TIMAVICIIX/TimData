package com.example.stardrawing.mainview.painting.paintingclass

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.atan2
import kotlin.math.sqrt

class NewBoardCreate(context: Context, attributeSet: AttributeSet?, defStyleAttributeSet: Int) :
    View(context, attributeSet, defStyleAttributeSet) {

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    //画笔模式
    private var drawModePer = PaintMode.PaintMode

    //View的宽与高
    private var viewPointF: PointF = PointF(0f, 0f)

    //新建画笔对象
    private lateinit var paintPer: PaintClass

    //画笔的宽度以及橡皮擦的宽度
    private var paintSize = dip2x(10f)
    private var eraseSize = dip2x(20f)

    //缓冲位图，记录指绘的位图
    private lateinit var bufferBitmap: Bitmap

    //缓冲画板，Bitmap上的参数在上面实现
    //默认画板为白色
    private lateinit var bufferCanvas: Canvas
    private var bufferCanvasColor: Int = Color.WHITE

    //触摸绘画的路径
    private var pathPer: Path = Path()

    /******保存路径的属性*****/
    //上次触摸绘画的位置
    private var lastDrawPointF: PointF = PointF(0f, 0f)

    //最大保存容量
    private val max = 20

    private var savePaths: ArrayList<PaintPath> = ArrayList(max)
    private var currPaths: ArrayList<PaintPath> = ArrayList(max)
    /**********************/


    /*****位移与拖拽的参照变量*****/
    //绘画参照变量
    private var actionXPer = 0f
    private var actionYPer = 0f

    //拖拽参照变量与缩放参照变量
    private var xTranslation = 0f
    private var yTranslation = 0f
    private var scalePer = 1f
    private var spacingPer = 0f

    //监测单指与双指的状况
    private var moveType = 1

    /*********↓私有方法↓********/
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        viewPointF.x = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        viewPointF.y = MeasureSpec.getSize(heightMeasureSpec).toFloat()

        setMeasuredDimension(viewPointF.x.toInt(), viewPointF.y.toInt())
        initCanvasAndPaint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawBitmap(bufferBitmap, 0f, 0f, null)
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event != null) {

            if (drawModePer != PaintMode.MoveMode) {

                val x = event.x
                val y = event.y
                when (event.action) {

                    MotionEvent.ACTION_DOWN -> {
                        lastDrawPointF.x = event.x
                        lastDrawPointF.y = event.y
                        pathPer.moveTo(lastDrawPointF.x, lastDrawPointF.y)
                    }

                    MotionEvent.ACTION_MOVE -> {
                        Log.d("NewBoardCreate:", "Moving")
                        pathPer.quadTo(
                            lastDrawPointF.x,
                            lastDrawPointF.y,
                            (lastDrawPointF.x + x) / 2,
                            (lastDrawPointF.y + y) / 2
                        )
                        bufferCanvas.drawPath(pathPer, paintPer.getPaint())
                        invalidate()
                        lastDrawPointF.x = x
                        lastDrawPointF.y = y
                    }

                    MotionEvent.ACTION_UP -> {
                        savePath()
                        pathPer.reset()
                    }

                }
            }


            if (drawModePer == PaintMode.MoveMode) {

                when (event.action and MotionEvent.ACTION_MASK) {

                    MotionEvent.ACTION_DOWN -> {
                        moveType = 1
                        actionXPer = event.rawX
                        actionYPer = event.rawY
                    }

                    MotionEvent.ACTION_POINTER_DOWN -> {
                        moveType = 2
                        spacingPer = getSpacing(event)
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (moveType == 1) {
                            xTranslation = xTranslation + event.rawX - actionXPer
                            yTranslation = yTranslation + event.rawY - actionYPer

                            translationX = xTranslation
                            translationY = yTranslation

                            actionXPer = event.rawX
                            actionYPer = event.rawY
                        } else if (moveType == 2) {
                            scalePer = scalePer * getSpacing(event) / spacingPer

                            scaleX = scalePer
                            scaleY = scalePer
                        }
                    }

                    MotionEvent.ACTION_UP -> moveType = 0
                    MotionEvent.ACTION_POINTER_UP -> moveType = 0

                }

            }

        }

        return super.onTouchEvent(event)
    }


    private fun initCanvasAndPaint() {
        bufferBitmap =
            Bitmap.createBitmap(viewPointF.x.toInt(), viewPointF.y.toInt(), Bitmap.Config.ARGB_8888)

        bufferCanvas = Canvas(bufferBitmap)
        bufferCanvas.drawColor(bufferCanvasColor)

        //默认画笔的颜色为黑色，绑定到该画板上
        paintPer = PaintClass(paintSize, bufferCanvasColor, Color.BLACK)
    }

    private fun getSpacing(event: MotionEvent): Float {
        val x = event.getX(0) - event.getX(1)
        val y = event.getY(0) - event.getY(1)
        return sqrt(x * x + y * y)
    }

    private fun getDegree(event: MotionEvent): Float {
        val x = event.getX(0) - event.getX(1)
        val y = event.getY(0) - event.getY(1)
        val radians = atan2(y, x)
        return Math.toDegrees(radians.toDouble()).toFloat()
    }

    private fun dip2x(depValue: Float): Int {
        val density = resources.displayMetrics.density
        return (depValue * density + 0.5f).toInt()
    }

    private fun setCanvasColor(tempColor: Int) {
        bufferCanvasColor = tempColor
    }

    private fun reDrawBitmap() {
        bufferBitmap.eraseColor(Color.TRANSPARENT)

        for (temp in currPaths) {
            bufferCanvas.drawPath(temp.getPath(), temp.getPaint())
        }
        invalidate()
    }

    private fun savePath() {

        if (savePaths.size == max) {
            savePaths.removeAt(0)
        }

        savePaths.clear()
        savePaths.addAll(currPaths)

        val path = Path(pathPer)
        val paint = Paint(paintPer.getPaint())

        savePaths.add(PaintPath(paint, path))
        currPaths.add(PaintPath(paint, path))
    }

    /******↓公有响应方法↓*******/
    fun setDrawMode(tempMode: PaintMode) {
        drawModePer = tempMode
        paintPer.reSetPaintMode(drawModePer)
    }

    fun clean() {

        savePaths.clear()
        currPaths.clear()

        bufferBitmap.eraseColor(Color.TRANSPARENT)
        bufferCanvas.drawColor(bufferCanvasColor)
        invalidate()
    }

    fun nextStep() {
        if (currPaths.size > 0) {
            currPaths.removeAt(currPaths.size - 1)
            reDrawBitmap()
        }
    }

    fun lastStep() {
        if (currPaths.size != savePaths.size) {
            if (savePaths.size > currPaths.size) {
                currPaths.add(savePaths[savePaths.size - 1])
                reDrawBitmap()
            }
        }
    }

    fun setPaintSize(tempPaintSize: Int) {
        this.paintSize = tempPaintSize
        paintPer.reSetPaintSize(paintSize)
    }

    fun setPaintColor(tempColor: Int) {
        paintPer.reSetPaintColor(tempColor)
    }

    fun setPaintMode(tempMode: PaintMode) {
        drawModePer = tempMode
        paintPer.reSetPaintMode(drawModePer)
    }


    /*******↓公有拉取方法↓*******/
    fun getPaintSize() = paintPer.getPaintSize()

    fun getCanvasColor() = bufferCanvasColor

    fun getPaintMode() = paintPer.getPaintMode()

}