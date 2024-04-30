package com.example.vacationventurepe.fragments.mainactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.vacationventurepe.databinding.ActivityMainFragmentMineBinding
import com.example.vacationventurepe.fragments.BaseFragment
import com.example.vacationventurepe.viewmodels.mainactivity.MainMineViewModel

class MainMineFragment : BaseFragment() {

    private var binding: ActivityMainFragmentMineBinding? = null

    private val bindingGet get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mineViewModel = ViewModelProvider(this)[MainMineViewModel::class.java]

        binding = ActivityMainFragmentMineBinding.inflate(inflater,container,false)
        val root:View = bindingGet.root

        val textView:TextView = bindingGet.textMine
        mineViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }

        return root
    }

}