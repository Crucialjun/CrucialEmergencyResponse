package com.example.crucialemergencyresponse

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InstructionsListAdapter {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val instructionTitle = itemView.findViewById<TextView>(R.id.txt_instruction_title)
        val instructionText = itemView.findViewById<TextView>(R.id.txt_instructions_text)
    }

}