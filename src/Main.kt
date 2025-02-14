fun main() {
    // Create some people
    val person1 = Person("Jenny", 1.55, "green")
    val person2 = Person("Steve", 1.8, "purple")
    val person3 = Person("Michelle", 1.55, "red")

    // Create rooms
    val bedroom = Room(8, 2, 7)
    val kitchen = Room(5, 2, 3)
    val livingRoom = Room(4, 3, 2)

    // Show room information before assigning owners and painting
    println("Before assigning owners and painting:")
    bedroom.info()
    kitchen.info()
    livingRoom.info()

    // Set owners for the rooms
    bedroom.assignOwner(person1)
    kitchen.assignOwner(person2)
    livingRoom.assignOwner(person3)

    // Show room information after assigning owners
    println("After assigning owners:")
    bedroom.info()
    kitchen.info()
    livingRoom.info()

    //create windows
    println("After windows:")
    val bedroomwin = Window(2, 3, "Bedroom Window 1")
    val kitchenwin = Window(2, 1, "Kitchen Window 1")
    val livingroomwin1 = Window(2, 2, "Living Room Window 1")
    val livingroomwin2 = Window(2, 2, "Living Room Window 2")
    val livingroomwin3 = Window(2, 24, "Living Room Window 3")

    //assign windows
    bedroom.assignWindow(bedroomwin)
    kitchen.assignWindow(kitchenwin)
    livingRoom.assignWindow(livingroomwin1)
    livingRoom.assignWindow(livingroomwin2)
    livingRoom.assignWindow(livingroomwin3)

    // Show room information after windows installed
    bedroom.info()
    kitchen.info()
    livingRoom.info()

    // Calculate tins of paint needed
    val tinCoverage = 10.0  // Each tin covers 10m²
    println("Tins of paint needed for each room:")
    println("Bedroom: ${bedroom.tinsNeeded(tinCoverage)} tins")
    println("Kitchen: ${kitchen.tinsNeeded(tinCoverage)} tins")
    println("Living Room: ${livingRoom.tinsNeeded(tinCoverage)} tins")

    // Paint rooms
    bedroom.paint()
    kitchen.paint()
    livingRoom.paint()
    println()

    // Show room information after painting
    println("After painting:")
    bedroom.info()
    kitchen.info()
    livingRoom.info()
}



// Cat class, controls and sets all the data
class Cat(val name: String, var legs: Int = 4) {
    var isSleeping: Boolean = false
    var isHungry: Boolean = false
    var bff: Cat? = null

    // Function to poke the cat
    fun poke() {
        if (isSleeping) {
            isSleeping = false
        } else {
            println("$name is angry")
        }
    }

    // Function to pet the cat
    fun pet() {
        println("$name is purring")
        if (!isSleeping) {
            isSleeping = true
            println("$name went to bed")
        }
    }

    // Make a new friend (BFF)
    fun makeFren(newFriend: Cat) {
        bff = newFriend
        newFriend.bff = this
    }

    // Override the toString method for custom object printing
    override fun toString(): String {
        var info: String = ""
        info += "Name: $name\n"
        info += "Legs: $legs\n"
        info += "Is Sleeping: $isSleeping\n"
        info += "Is Hungry: $isHungry\n"
        info += "Best Friend: ${bff?.name}"

        return info
    }
}

// Room class for calculating area, volume, and handling the owner and paint color
class Room(val width: Int, val height: Int, val depth: Int) {
    var owner: Person? = null  // Owner of the room
    var colour: String = "unpainted"  // Default color is "unpainted"
    val windows = mutableListOf<Window>()
    val door = 2
    // Method to calculate volume of the room
    fun volume(): Int {
        return width * height * depth
    }

    // Method to calculate interior area of the room
    fun interiorArea(): Int {
        var area =  2 * (width * height + height * depth + width * depth) - (door)

        windows.forEach { area -= it.area() }

        return area
    }

    // Method to set the owner of the room
    fun assignOwner(newOwner: Person) {
        owner = newOwner
    }

    // Method to assign a window to the room
    fun assignWindow(newWindow: Window) {
        if (interiorArea() > newWindow.area()){
            windows.add(newWindow)
            }
        else{
            println("${newWindow.label} is too big for the room")
        }
    }

    // Method to display the room's information (volume, area, and owner)
    fun info() {
        println("Room Info:")
        println("Owner: ${owner?.name ?: "No owner"}")
        println("Volume: ${volume()}m³")
        println("Interior Area: ${interiorArea()}m²")
        println("Colour: $colour")
        println("Windows: ${windows.count()}")
//        println("Window: ${window?.area() ?: "No window"}m²")
        println()
    }

    // Method to paint the room based on the owner's favourite colour
    fun paint() {
        if (owner != null) {
            colour = owner?.favcolor ?: "unpainted"
        } else {
            println("Room has no owner, cannot paint.")
        }
    }

    // Method to calculate how many tins of paint are needed to cover the room
    fun tinsNeeded(tinCoverage: Double): Double {
        val area = interiorArea().toDouble()
        return area / tinCoverage
    }
}


class Window(val width: Int, val height: Int, val label: String) {
    fun area():Int{
        return width * height
    }
    override fun toString(): String {
        return "$label ($width x $height)"
    }
}

// Person class to define people's attributes
class Person(val name: String, var height: Double, var favcolor: String) {

    // Method to generate a greeting message
    fun greet(): String {
        return "Hello, I'm $name, I'm $height meters tall and I like the colour $favcolor."
    }
}
