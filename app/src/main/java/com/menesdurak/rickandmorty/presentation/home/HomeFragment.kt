package com.menesdurak.rickandmorty.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.menesdurak.rickandmorty.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val locationsViewModel: LocationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationsViewModel.getLocationsPage(1)

        observeUiState()
    }

    private fun observeUiState() {
        locationsViewModel.homeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                    binding.progressBar.isVisible = false
                }

                HomeUiState.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is HomeUiState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.textview.text = it.data.results[0].name
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}