package com.goodexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class BottomGuide : Fragment() {

    private lateinit var bottomBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_guide_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomBtn=view.findViewById(R.id.bottomBtn)

        bottomBtn.setOnClickListener {

            Toast.makeText(context,"It's Bottom Callback!!!",Toast.LENGTH_SHORT).show()

        }

    }

}