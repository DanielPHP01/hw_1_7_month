package com.example.hw_1_7_month.presentation.ui.fragment.getallfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_1_7_month.R
import com.example.hw_1_7_month.databinding.FragmentGetAllNoteBinding
import com.example.hw_1_7_month.presentation.base.BaseFragment
import com.example.hw_1_7_month.presentation.ui.fragment.getallfragment.adapter.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetAllNoteFragment : BaseFragment() {
    private val viewModel: GetAllNoteViewModel by viewModels()
    private lateinit var binding: FragmentGetAllNoteBinding
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NoteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetAllNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        utils()
        getAll()
    }

    private fun utils() {

        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }
    }

    private fun delete() {

        viewModel.deleteNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = {
                Toast.makeText(requireContext(), "error${it}", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {

            })


    }

    private fun getAll() {
        viewModel.getAllNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE


            },
            Error = {
                Toast.makeText(requireContext(), "error${it}", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                binding.recyclerView.adapter = adapter

                adapter.setList(it)
            })
    }
}