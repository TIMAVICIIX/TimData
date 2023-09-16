package com.example.stardrawing.mainview.center

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseFragment
import com.example.stardrawing.mainview.main.MainViewMainFrag
import com.example.stardrawing.tool.TotalVal
import com.example.stardrawing.tool.toasttool.TimToast.toastItShortLength
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener

@Suppress("DEPRECATION")
class CenterFragment : BaseFragment(), OnBannerListener<Int> {

    private lateinit var jumpToBoardBtn: Button
    private lateinit var jumpToPaintingBtn: Button
    private lateinit var mainFrag: MainViewMainFrag

    private lateinit var postBanner: Banner<Int, BannerImageAdapter<Int>>
    private lateinit var postList: ArrayList<Int>


    private val recommendWorkList = ArrayList<RecommendWork>()
    private lateinit var recommendRecycleView: RecyclerView



    class PostBannerAdapter(list: ArrayList<Int>) : BannerImageAdapter<Int>(list) {

        override fun onBindView(holder: BannerImageHolder?, data: Int?, position: Int, size: Int) {
            if (data != null) {
                holder?.imageView?.setImageResource(data)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_center, container, false)
    }

    override fun OnBannerClick(data: Int?, position: Int) {
        "You Click The $position".toastItShortLength(context)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVal(view)

        postBanner.setAdapter(PostBannerAdapter(postList))
        postBanner.isAutoLoop(true)
        postBanner.indicator = CircleIndicator(context)
        postBanner.setLoopTime(5000)
        postBanner.setOnBannerListener(this)

        mainFrag=fragmentManager?.findFragmentById(R.id.mainview_mainfrag) as MainViewMainFrag

        jumpToBoardBtn.setOnClickListener {
           mainFrag.replaceFragment(TotalVal.REPLACE_TO_BOARD_FRAGMENT)
        }

        jumpToPaintingBtn.setOnClickListener {
            mainFrag.replaceFragment(TotalVal.REPLACE_TO_PAINTING_FRAGMENT)
        }


        val layoutManager = GridLayoutManager(context, 2)
        recommendRecycleView.layoutManager = layoutManager
        val adapter = context?.let { CenterRecycleAdapter(it, recommendWorkList) }
        recommendRecycleView.adapter = adapter
        recommendRecycleView.isNestedScrollingEnabled = true

    }


    private fun initVal(view: View) {

        jumpToBoardBtn = view.findViewById(R.id.center_view_jumptoboardBtn)
        jumpToPaintingBtn = view.findViewById(R.id.center_view_jumptopaintingBtn)

        postBanner = view.findViewById(R.id.postCenterBanner)!!

        postList = ArrayList(5)
        postList.add(R.drawable.center_view_post01)
        postList.add(R.drawable.center_view_post02)
        postList.add(R.drawable.center_view_post03)
        postList.add(R.drawable.center_view_post04)
        postList.add(R.drawable.center_view_post05)

        recommendWorkList.clear()
        repeat(50) {
            recommendWorkList.add(
                RecommendWork(
                    "UnKnow",
                    0,
                    "UnKnow",
                    R.drawable.center_recommend_unknow
                )
            )
        }
        recommendRecycleView = view.findViewById(R.id.CenterRecommendRecycleView)
    }

}
