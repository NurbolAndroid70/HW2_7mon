package com.example.myapplication.ui.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.BaseDao
import com.example.myapplication.data.local.models.DoorsEntity
import com.example.myapplication.databinding.FragmentDoorsBinding
import com.example.myapplication.domain.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DoorsFragment : Fragment() {
    private lateinit var binding: FragmentDoorsBinding
    private val viewModel: DoorsViewModel by viewModels()
    private val adapter = DoorsAdapter()

    @Inject
    lateinit var dao: BaseDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRequest()
        binding.doorsRecyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.doorsFlow.collect {
                when (it) {
                    is UiState.Empty -> {
                        adapter.submitList(emptyList())
                        adapter.notifyDataSetChanged()
                    }

                    is UiState.Error -> {
                        Toast.makeText(requireContext(), "Произошла ошибка", Toast.LENGTH_LONG)
                            .show()
                    }

                    is UiState.Loading -> {}
                    is UiState.Success -> {
                        if (dao.getDoorsCount() == 0) {
                            viewModel.viewModelScope.launch {
                                viewModel.getDoors()
                                adapter.submitList(it.data?.data)
                                val data = DoorsEntity(
                                    count = adapter.currentList.size
                                )
                                dao.insertDoorsModel(data)
                            }
                        } else {
                            binding.doorRefreshLayout.setOnRefreshListener {
                                viewModel.viewModelScope.launch {
                                    viewModel.getDoors()
                                    adapter.submitList(it.data?.data)
                                }
                                binding.doorRefreshLayout.isRefreshing = false
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initRequest() {
        viewModel.viewModelScope.launch { viewModel.getDoors() }
    }
}