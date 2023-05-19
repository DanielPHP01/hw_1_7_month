package com.example.hw_1_7_month.presentation.ui.fragment.getallfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_1_7_month.databinding.ItemNoteBinding
import com.example.hw_1_7_month.domain.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var list = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    @JvmName("setList1")
    fun setList(list: List<Note>) {
        this.list = list
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteEntity: Note) {
            with(binding) {
                tvTextTitle.text = noteEntity.title
                tvDesc.text = noteEntity.desc
            }

        }
    }
}