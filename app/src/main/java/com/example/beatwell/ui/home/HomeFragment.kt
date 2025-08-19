package com.example.beatwell.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.beatwell.Mon1Activity
import com.example.beatwell.Mon2Activity
import com.example.beatwell.Mon3Activity
import com.example.beatwell.Mon4Activity
import com.example.beatwell.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Handle click on breakfast
        binding.breakfast.setOnClickListener {
            val intent = Intent(requireActivity(), Mon1Activity::class.java)
            startActivity(intent)
        }

        binding.lunch.setOnClickListener {
            val intent = Intent(requireActivity(),Mon2Activity::class.java)
            startActivity(intent)
        }

        binding.snacks.setOnClickListener {
            val intent = Intent(requireActivity(),Mon3Activity::class.java)
            startActivity(intent)
        }

        binding.dinner.setOnClickListener {
            val intent = Intent(requireActivity(),Mon4Activity::class.java)
            startActivity(intent)
        }

        // ViewModel
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.textHome.text = it
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}