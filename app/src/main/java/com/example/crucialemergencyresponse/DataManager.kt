package com.example.crucialemergencyresponse

import com.google.android.gms.maps.model.LatLng

object DataManager {
    private val mechanics = ArrayList<MechanicInfo>()
    private val instructions = ArrayList<InstructionsInfo>()

    init{
        initializeMechs()
        initializeInstructions()
    }

    private fun initializeInstructions() {
        val instruction = InstructionsInfo("How change a tire","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        instructions.add(instruction)
    }


    private fun initializeMechs() {
        val mech = MechanicInfo("Cole Hopkins","0754231345", LatLng(32.00,-120.08))
        mechanics.add(mech)
    }
}


