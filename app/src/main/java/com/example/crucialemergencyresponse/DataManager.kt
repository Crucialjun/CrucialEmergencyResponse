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
        var instruction = InstructionsInfo("How change a tire","A flat tire typically shows up unexpectedly and catapults itself onto the top of your priority list. A flat tire can happen to anyone at any time. It doesn’t matter if you were already running late or if you’re wearing a cocktail dress. Regardless of your situation, the basic mechanics of changing a tire are the same whether you’re working with a car, truck, van, or SUV. Below, I’ve broken down how to change a tire in 10 simple steps.\n" +
                "1. Find a Safe Place to Pull Over\n" +
                "2. Use Your Hazard Lights and Parking Brake\n" +
                "3. Check for Materials\n" +
                "4. Loosen the Lug Nuts\n" +
                "5. Lift Your Vehicle Off the Ground\n" +
                "6. Remove the Lug Nuts and the Tire\n" +
                "7. Place the Spare Tire on the Car\n" +
                "8. Replace the Lug Nuts\n" +
                "9. Lower Your Vehicle and Begin Tightening\n" +
                "10. Lower Your Vehicle Completely and Finish Tightening\n" +
                "Extra Tips for How to Change a Tire\n" +
                "Finish up by putting your old tire in the trunk and cleaning up any tools you used. Depending on what’s wrong with it, your old tire might be salvageable. Bring it to a trusted mechanic who can test and possibly repair it. Otherwise, you’ll need to invest in a new spare, which should be done immediately. It’s never a good idea to operate a vehicle without a spare tire; make sure to pre-check your spare tire and parts to make sure it is ready to use in case of an emergency.\n" +
                "\n")
        instructions.add(instruction)

        instruction = InstructionsInfo("How check oil level","You should check your car’s oil at least once a month to make sure that there’s enough oil and that it isn’t contaminated. Oil reduces the friction in your engine and keeps it running smoothly. When you check your oil, if it is dirty or smells of gasoline, it’s time for your oil to be changed. You should also check the levels using the oil dipstick – if you’re oil is clean but only reaches the “Add” part of the dipstick, you’ll need to add more oil.\n" +
                "Some European vehicles don’t have an oil dipstick. If you can’t find one on your vehicle, check the owner’s manual for how to check your oil.\n" +
                "The process for how to check your oil is simple and involves using the dip stick to see levels and test quality. To find out whether your vehicle needs oil, follow these steps:\n" +
                "1.\tPull out the dip stick and wipe it off on a clean, lint-free rag.\n" +
                "Be sure the engine is cold (or has been off for at least ten minutes) before you check the oil. The location of the oil dipstick depends on whether your vehicle has an in-line engine (rear-wheel drive) as shown here.\n" +
                "\n" +
                "If you have a transverse engine (front-wheel drive) your dipstick should be located near the front of the engine, as shown here.\n" +
                "\n" +
                "2.\tInsert the stick back into the pipe.\n" +
                "If the dipstick gets stuck on the way in, turn it around. The pipe it fits into is curved, and the metal stick bends naturally in the direction of the curve if you put it back in the way it came out.\n" +
                "3.\tPull the dipstick out again and look at the film of oil on the end of the stick.\n" +
                "Note how high the oil film reaches on the dipstick and the condition of the oil, and add or change the oil as needed.\n" +
                "You don’t add oil into the tiny tube that the dipstick sits in; that’s just asking for messy frustration. Look for a screw-off cap on top of the largest part of the engine. It could be blank or it could be labeled “Oil Cap” or something similar, and it might even indicate which grade of oil you ought to be using in your car. Unscrew that cap and add oil as needed.\n" +
                "\n" +
                "4.\tPut the dipstick back into the pipe. You’re done!\n" +
                "Oil turns black pretty quickly, but that doesn’t affect the quality. Rub a little between your thumb and index finger, and if it leaves a dirty smudge, it probably needs to be changed.\n" +
                "If your oil looks clean enough but only reaches the “Add” level on the dipstick, you need to add oil. You can buy oil the next time you fill up with gas at the service station or you can find it at auto supply stores, supermarkets, discount stores, and large drugstores.\n" +
                "\n")
        instructions.add(instruction)

        instruction = InstructionsInfo("How to Jump Start Your Car","If your battery has died, you may be able to use jumper cables to jump start it from some good Samaritan’s vehicle. If you can safely use jumper cables on your vehicle, make sure that the battery on the good Samaritan’s vehicle has at least as much voltage as your own. As long as you hook up the cables properly, it doesn’t matter whether your vehicle has negative ground and the GS’s vehicle has positive ground, or your vehicle has an alternator and the GS’s vehicle has a generator.\n" +
                "If either vehicle has an electronic ignition system or is an alternatively fueled vehicle, the use of jumper cables may damage it.\n" +
                "To safely jump a start, follow these steps:\n" +
                "1.\tTake out your jumper cables.\n" +
                "It’s a good idea to buy a set of jumper cables and keep them in the trunk compartment. If you don’t have jumper cables, you have to find a good Samaritan who not only is willing to assist you but who has jumper cables as well.\n" +
                "2.\tPlace both vehicles in Park or Neutral and shut off the ignition in both cars.\n" +
                "Engage both parking brakes as well.\n" +
                "3.\tAttach one of the red clips to the positive terminal of your battery.\n" +
                "It has “POS” or “+” on it, or it’s bigger than the negative terminal.\n" +
                "4.\tAttach the other red clip to the positive terminal of the other car.\n" +
                "5.\tAttach one of the black clips to the negative terminal on the other battery.\n" +
                "6.\tAttach the last black clip to an unpainted metal surface on your car that isn’t near the battery.\n" +
                "Use one of the metal struts that holds the hood open.\n" +
                "The cables should look like this.\n" +
                "Make sure to connect jumper cables in the proper order.\n" +
                "7.\tStart the working vehicle and let the engine run for a few minutes.\n" +
                "8.\tTry to start your vehicle.\n" +
                "If it won’t start, make sure that the cables are properly connected and have the good Samaritan run his or her engine for five minutes. Then try to start your car again. If it still won’t start, your battery may be beyond help.\n" +
                "If the jump works and your car starts, don’t shut off your engine! Drive around for at least 15 minutes to recharge your battery. If the car won’t start the next time you use it, the battery isn’t holding a charge and needs to be replaced.\n")
        instructions.add(instruction)

        instruction = InstructionsInfo("How to Tell Whether Your Vehicle Needs a Tune-up","Tune-up intervals vary from one vehicle to another. Most older vehicles with non-electronic ignitions should be tuned every 10,000 to 12,000 miles or every year, whichever comes first. Newer cars with electronic ignition and fuel injection systems are scheduled to go from 25,000 miles to as many as 100,000 miles without needing a major tune-up.\n" +
                "Refer to your owner’s manual for recommended tune-up intervals, but be aware that even if it says that the vehicle doesn’t require scheduled tune-ups very often, it’s in your best interest to check periodically that your vehicle is working at peak efficiency. If you do a lot of stop-and-go driving or pull heavy loads (like a camper or boat), your ignition system may need to be tuned more often. Here are a couple of symptoms that tell you that your electronic ignition system may need to be tuned or adjusted:\n" +
                "•\tThe car stalls a lot. The spark plugs may be fouled or worn, the gap between the spark plug electrodes may need adjusting, or an electronic sensing device may need to be adjusted.\n" +
                "If you’re having trouble pinpointing why your vehicle is stalling, you can help your automotive technician diagnose the problem by paying attention to whether the engine stalls when it’s hot or cold or when the air conditioner is on.\n" +
                "•\tThe engine is running roughly when idling or when you accelerate. Chances are the vehicle needs a tune-up.\n" +
                "•\tThe car gets harder to start. The problem can be in the starting system (for example, a weak battery), in the fuel system (for example, a weak fuel pump), or in the ignition system, or can be due to a faulty electronic component, such as the electronic control unit (ECU).\n")
        instructions.add(instruction)

    }


    private fun initializeMechs() {
        var mechanic = MechanicInfo(
            "Cole Hopkins",
            "0754231345",
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


