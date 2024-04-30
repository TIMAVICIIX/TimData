package com.example.vacationventurepe.fragments.mainactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.vacationventurepe.databinding.ActivityMainFragmentHistoryBinding
import com.example.vacationventurepe.fragments.BaseFragment
import com.example.vacationventurepe.viewmodels.mainactivity.MainHistoryViewModel

class MainHistoryFragment : BaseFragment() {

    private var binding: ActivityMainFragmentHistoryBinding? = null

    private val bindGet get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val historyViewModel = ViewModelProvider(this)[MainHistoryViewModel::class.java]

        binding = ActivityMainFragmentHistoryBinding.inflate(inflater, container, false)

        val root: View = bindGet.root

        val textView: TextView = bindGet.textHistory
        historyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root


    }

}