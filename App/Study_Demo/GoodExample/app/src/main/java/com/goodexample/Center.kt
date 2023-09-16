package com.goodexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class Center:Fragment() {

    private lateinit var centerBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.center_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        centerBtn=view.findViewById(R.id.centerBtn)

        centerBtn.setOnClickListener {

            Toast.makeText(context,"It's Center Callback!!!",Toast.LENGTH_SHORT).show()

        }
    }

}