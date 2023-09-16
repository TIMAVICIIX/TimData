package com.example.stardrawing.mainview.painting

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseActivity
import com.example.stardrawing.mainview.painting.paintingclass.NewBoardCreate
import com.example.stardrawing.mainview.painting.paintingclass.PaintMode
import com.example.stardrawing.tool.activitytool.StatusBar
import com.example.stardrawing.tool.toasttool.TimToast.toastItLongLengthRobo

@Suppress("DEPRECATION")
class NewPaintingActivity :BaseActivity() {

    private lateinit var statusBar: StatusBar

    //mainBoard
    private lateinit var mainBoard: NewBoardCreate

    //SideView
    private lateinit var sideLayout: LinearLayout

    private lateinit var paintBtn: Button
    private lateinit var eraseBtn: Button
    private lateinit var boardBtn: Button
    private lateinit var shapeBtn: Button
    private lateinit var moveBtn: Button
    private lateinit var roboBtn: Button

    private lateinit var showLayoutBtn: Button
    private lateinit var hideLayoutBtn: Button

    //Top
    private lateinit var topLayout: LinearLayout

    private lateinit var lastStepBtn: Button
    private lateinit var nextStepBtn: Button
    private lateinit var cleanBtn: Button
    private lateinit var createRandBtn: Button
    private lateinit var saveBtn: Button
    private lateinit var leaveBtn: Button

    private lateinit var modeMenber: PaintMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        statusBar = StatusBar(this)
        statusBar.hideAll()

        setContentView(R.layout.new_paint_create_view)

        initVar()
        setRequest()
    }

    override fun onResume() {

        statusBar = StatusBar(this)
        statusBar.hideAll()

        super.onResume()
    }

    override fun onRestart() {

        statusBar = StatusBar(this)
        statusBar.hideAll()

        super.onRestart()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (supportFragmentManager.backStackEntryCount != 0){
                supportFragmentManager.popBackStack()
            }else{
                exitDouble(2000,"再按一次退出画板")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun initVar() {

        //MainBoard Init
        mainBoard = findViewById(R.id.newDrawContent)

        //Init Side Area
        sideLayout = findViewById(R.id.new_painting_create_side_selectlayout)

        paintBtn = findViewById(R.id.new_painting_create_paintbtn)
        eraseBtn = findViewById(R.id.new_painting_create_erasebtn)
        boardBtn = findViewById(R.id.new_painting_create_boardbtn)
        shapeBtn = findViewById(R.id.new_painting_create_shapebtn)
        moveBtn = findViewById(R.id.new_painting_create_movebtn)
        roboBtn = findViewById(R.id.new_painting_create_robohelperbtn)

        showLayoutBtn = findViewById(R.id.ShowSideSelectBtn)
        hideLayoutBtn = findViewById(R.id.HideSideSelectBtn)

        //Init Top Area
        topLayout = findViewById(R.id.new_painting_create_top_selectlayout)

        lastStepBtn = findViewById(R.id.new_painting_create_laststepbtn)
        nextStepBtn = findViewById(R.id.new_painting_create_nextstepbtn)
        cleanBtn = findViewById(R.id.new_painting_create_cleanbtn)
        createRandBtn = findViewById(R.id.new_painting_create_newranderbtn)
        saveBtn = findViewById(R.id.new_painting_create_savebtn)
        leaveBtn = findViewById(R.id.new_painting_create_leavebtn)

    }

    private fun setRequest() {

        //side and top Select Area
        showLayoutBtn.setOnClickListener {
            sideLayout.visibility = View.VISIBLE
            topLayout.visibility = View.VISIBLE
            it.visibility = View.INVISIBLE
        }

        hideLayoutBtn.setOnClickListener {
            sideLayout.visibility = View.INVISIBLE
            topLayout.visibility = View.INVISIBLE
            showLayoutBtn.visibility = View.VISIBLE
        }

        paintBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        eraseBtn.setOnClickListener {

            if (mainBoard.getPaintMode() == PaintMode.PaintMode) {
                mainBoard.setPaintMode(PaintMode.EraseMode)
                "已转换为橡皮擦模式".toastItLongLengthRobo(this)
            } else if (mainBoard.getPaintMode() == PaintMode.EraseMode) {
                mainBoard.setPaintMode(PaintMode.PaintMode)
                "已转换为画笔模式".toastItLongLengthRobo(this)
            }

        }

        boardBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        shapeBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        moveBtn.setOnClickListener {
            if (mainBoard.getPaintMode() != PaintMode.MoveMode) {
                modeMenber = mainBoard.getPaintMode()
                mainBoard.setPaintMode(PaintMode.MoveMode)
                "已转换为移动模式".toastItLongLengthRobo(this)
            } else if (mainBoard.getPaintMode() == PaintMode.MoveMode) {
                mainBoard.setPaintMode(modeMenber)
                "已解除移动模式".toastItLongLengthRobo(this)
            }

        }

        roboBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        nextStepBtn.setOnClickListener {
            mainBoard.nextStep()
        }

        lastStepBtn.setOnClickListener {
            mainBoard.lastStep()
        }

        cleanBtn.setOnClickListener {
            /*AlertDialog.Builder(this).apply {
                setTitle("确定要清除所有痕迹吗")
                setMessage("将清除画板上的所有痕迹并且无法返回上一步。")
                setCancelable(false)
                setPositiveButton("确定"){
                        _,_ -> mainBoard.clean()
                }
                setNegativeButton("取消"){
                    _,_ ->
                }
                show()
            }*/
            mainBoard.clean()
        }

        createRandBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        saveBtn.setOnClickListener {
            "功能未开放，敬请期待".toastItLongLengthRobo(this)
        }

        leaveBtn.setOnClickListener {
                exitDouble(2000,"再按一次退出画板")
        }


    }

}