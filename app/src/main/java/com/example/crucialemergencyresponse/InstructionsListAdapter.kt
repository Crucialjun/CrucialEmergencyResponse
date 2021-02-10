package com.example.crucialemergencyresponse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InstructionsListAdapter(
    val context : Context,
    private val instructions : List<InstructionsInfo>
    ) : RecyclerView.Adapter<InstructionsListAdapter.ViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val instructionTitle: TextView = itemView.findViewById(R.id.txt_instruction_title)
        val instructionText: TextView = itemView.findViewById(R.id.txt_instructions_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(
            R.layout.instruction_list_layout,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val instruction = instructions[position]

        holder.instructionTitle.text = instruction.title
        holder.instructionText.text = instruction.text
    }

    override fun getItemCount(): Int {
        return instructions.size
    }

}