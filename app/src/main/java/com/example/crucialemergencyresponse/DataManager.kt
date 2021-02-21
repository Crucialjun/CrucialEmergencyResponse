package com.example.crucialemergencyresponse

object DataManager {
    val mechanics = ArrayList<MechanicInfo>()
    val towTrucks = ArrayList<TowTruckInfo>()
    val fillingStations = ArrayList<FillingStationInfo>()
    val ambulances = ArrayList<AmbulanceInfo>()
    val instructions = ArrayList<InstructionsInfo>()

    init{
        initializeMechs()
        initializeTowTrucks()
        initializeFillingStations()
        initializeAmbulances()
        initializeInstructions()
    }

    private fun initializeInstructions() {
        var instruction = InstructionsInfo("How change a tire","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        instructions.add(instruction)

        instruction = InstructionsInfo("How check oil level","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        instructions.add(instruction)

        instruction = InstructionsInfo("How to set proper seat level","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        instructions.add(instruction)

        instruction = InstructionsInfo("How change clean the windscreen","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        instructions.add(instruction)
    }


    private fun initializeMechs() {
        var mechanic = MechanicInfo(
            "Cole Hopkins",
            "0754231345"
        )

        mechanics.add(mechanic)

        mechanic = MechanicInfo(
            "Crucial Jun",
            "0754231345"
        )

        mechanics.add(mechanic)

        mechanic = MechanicInfo(
            "John Doe",
            "0754231345"
        )

        mechanics.add(mechanic)

        mechanic = MechanicInfo(
            "Miriam Cain",
            "0754231345"
        )

        mechanics.add(mechanic)


    }

    private fun initializeTowTrucks() {
        var towTruck = TowTruckInfo(
            "Cole Hopkins",
            "0754231345"
        )

        towTrucks.add(towTruck)

        towTruck = TowTruckInfo(
            "Crucial Jun",
            "0754231345"
        )

        towTrucks.add(towTruck)

        towTruck = TowTruckInfo(
            "John Doe",
            "0754231345"
        )

        towTrucks.add(towTruck)


    }
    private fun initializeAmbulances() {
        var ambulance = AmbulanceInfo(
            "St Johns Ambulance",
            "0754231345"
        )

        ambulances.add(ambulance)

        ambulance = AmbulanceInfo(
            "AA Ambulance",
            "0754231345"
        )

        ambulances.add(ambulance)

        ambulance = AmbulanceInfo(
            "County Ambulance",
            "0754231345"
        )

        ambulances.add(ambulance)


    }

    private fun initializeFillingStations() {
        var fillingStation = FillingStationInfo(
            "Shell",
            "0754231345"
        )

        fillingStations.add(fillingStation)

        fillingStation = FillingStationInfo(
            "Total",
            "0754231345"
        )

        fillingStations.add(fillingStation)

        fillingStation = FillingStationInfo(
            "BP",
            "0754231345"
        )

        fillingStations.add(fillingStation)


    }
}


