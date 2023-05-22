package com.example.hw_1_7_month.presentation.ui.fragment.createnotefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.presentation.base.BaseFragment
import com.example.lesson1month8.databinding.FragmentCreateNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment() {
    private val viewModel: CreateViewModel by viewModels()
    private lateinit var binding: FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        binding.btnDesc.setOnClickListener {
            if (arguments?.getInt("id") != null) {
                val note = arguments?.getSerializable("note") as Note
                note.title = binding.tvTitle.text.toString()
                note.desc = binding.tvDesc.text.toString()
                editNote(note)
            } else {
                val note = Note(
                    title = binding.tvTitle.text.toString(),
                    desc = binding.tvDesc.text.toString()
                )
                createNote(note)
            }
        }
    }

    private fun createNote(note: Note) {
        viewModel.createNote(note)
        viewModel.createNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            },
            onSuccess = { createdNote ->
                Log.d("ololo", "Created note: $createdNote")
                findNavController().navigateUp()
            }
        )
    }

    private fun editNote(note: Note) {
        viewModel.editNote(note)
        viewModel.editNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                // Handle edit note success
            }
        )
    }
}