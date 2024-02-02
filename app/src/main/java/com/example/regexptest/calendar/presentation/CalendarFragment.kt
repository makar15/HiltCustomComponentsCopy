package com.example.regexptest.calendar.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.regexptest.R
import com.example.regexptest.calendar.di.CalendarApp
import com.example.regexptest.databinding.FragmentCalendarBinding
import com.example.regexptest.smoothie.di.components.SmoothieFragmentEntryPoint
import com.example.regexptest.smoothie.presentation.SmoothieFragment
import com.example.regexptest.smoothie.presentation.viewmodel.SmoothieViewModelProviderFactory
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalendarFragment : SmoothieFragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    @Inject
    @CalendarApp
    override lateinit var viewModelProviderFactory: Lazy<SmoothieViewModelProviderFactory>

    @Inject
    @CalendarApp
    override lateinit var fragmentEntryPoint: SmoothieFragmentEntryPoint

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val webWrapper = fragmentEntryPoint.webWrapper()
        Log.d("MYTAG", "AppId = ${smoothieViewModel.appId} ; WebWrapper = $webWrapper ; $this")
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}