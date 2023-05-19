package com.example.hw_1_7_month.presentation.ui.fragment.createnotefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw_1_7_month.databinding.FragmentCreateNoteBinding
import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment() {
    private val viewModel: CreateViewModel by viewModels()
    private lateinit var binding: FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        create()
    }

    private fun edit() {
        viewModel.editNoteState.collectState(
            onLoading = {
                binding.progressBar.visibility = View.VISIBLE
            },
            Error = {
                Toast.makeText(requireContext(), "error${it}", Toast.LENGTH_SHORT).show()

            },
            onSuccess = {

            }
        )

    }

    private fun create() {
        binding.btnDesc.setOnClickListener {
            val title = binding.tvTitle.text.toString()
            val description = binding.tvDesc.text.toString()
            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните", Toast.LENGTH_SHORT).show()
            } else {

                viewModel.createNoteState.collectState(
                    onLoading = {
                        binding.progressBar.visibility = View.VISIBLE
                    },
                    Error = {
                        Toast.makeText(requireContext(), "error${it}", Toast.LENGTH_SHORT).show()
                    },
                    onSuccess = {
                        Note(0, title, description)
                        Log.e("ololo", "create:${it} ")
                        findNavController().navigateUp()
                    })
            }
        }
    }
}