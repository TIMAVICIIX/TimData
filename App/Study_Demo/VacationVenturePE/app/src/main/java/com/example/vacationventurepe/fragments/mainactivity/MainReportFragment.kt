package com.example.vacationventurepe.fragments.mainactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.vacationventurepe.databinding.ActivityMainFragmentReportBinding
import com.example.vacationventurepe.fragments.BaseFragment
import com.example.vacationventurepe.viewmodels.mainactivity.MainReportViewModel

class MainReportFragment : BaseFragment() {

    private var binding: ActivityMainFragmentReportBinding? = null

    private val bindingGet get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val reportViewModel = ViewModelProvider(this)[MainReportViewModel::class.java]

        binding = ActivityMainFragmentReportBinding.inflate(inflater,container,false)

        val root:View = bindingGet.root

        val textView: TextView = bindingGet.textReport
        reportViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }

        return root

    }

}