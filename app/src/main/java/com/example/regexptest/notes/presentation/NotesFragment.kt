package com.example.regexptest.notes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.regexptest.R
import com.example.regexptest.databinding.FragmentNotesBinding
import com.example.regexptest.databinding.TestPlateBinding
import com.example.regexptest.notes.di.NotesApp
import com.example.regexptest.smoothie.di.components.SmoothieFragmentEntryPoint
import com.example.regexptest.smoothie.presentation.SmoothieFragment
import com.example.regexptest.smoothie.presentation.viewmodel.SmoothieViewModelProviderFactory
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesFragment : SmoothieFragment() {

    private var _binding: FragmentNotesBinding? = null
    private lateinit var testPlate: TestPlateBinding
    private val binding get() = _binding!!

    @Inject
    @NotesApp
    override lateinit var viewModelProviderFactory: Lazy<SmoothieViewModelProviderFactory>

    @Inject
    @NotesApp
    override lateinit var fragmentEntryPoint: SmoothieFragmentEntryPoint

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val webWrapper = fragmentEntryPoint.webWrapper()
        Log.d("MYTAG", "AppId = ${smoothieViewModel.appId} ; WebWrapper = $webWrapper ; $this")
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testPlate = TestPlateBinding.inflate(layoutInflater, binding.root, false)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}