package com.example.hw_1_7_month.presentation.ui.fragment.getallfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_1_7_month.presentation.base.BaseFragment
import com.example.hw_1_7_month.presentation.ui.fragment.getallfragment.adapter.NoteAdapter
import com.example.lesson1month8.R
import com.example.lesson1month8.databinding.FragmentGetAllNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetAllNoteFragment : BaseFragment() {
    private val viewModel: GetAllNoteViewModel by viewModels()
    private lateinit var binding: FragmentGetAllNoteBinding
    private lateinit var adapter: NoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetAllNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NoteAdapter()
        binding.recyclerView.adapter = adapter
        setupUtils()
        getAllNotes()
    }

    private fun setupUtils() {
        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }
    }

    private fun getAllNotes() {
        viewModel.getAllNotes()
        viewModel.getAllNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            },
            onSuccess = { notes ->
                binding.progressBar.visibility = View.GONE
                adapter.setList(notes)
            }
        )
    }

    private fun deleteNote() {
        viewModel.deleteNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                // Handle delete note success
            }
        )
    }
}