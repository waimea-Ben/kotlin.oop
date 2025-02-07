fun main() {
    val cat1 = Cat("Tom")
    val cat2 = Cat("mike", 3)
    val room1 = Room(8, 9, 7)  // Create a room with dimensions
    println("The volume of room1 is: ${room1.volume()}m³")  // Print the volume of the room
    println("The interior area of room1 is: ${room1.interiorArea()}m²")  // Print the interior area

}
class Cat(val name : String, var legs: Int = 4) {
    var isSleeping: Boolean = false;
    var isHungry: Boolean = false;
    var bff: Cat? = null

    fun poke(){
        if (isSleeping) {
            isSleeping = false
        }
        else{
            println("$name is angry")
        }

    }

    fun pet(){
        println("$name is purring")
        if (!isSleeping) {
            isSleeping = true
            println("$name went to bed")
        }

    }
    fun makeFren(newFriend:Cat){
    bff = newFriend
        newFriend.bff = this
    }


    //this method is run when the object is created
    init{
        println("creating a new cat")
    }
    //this replaces default function that prints objects id with more usefl

    override fun toString(): String{
        var info: String = ""

        info += "$name\n"
        info += "$legs\n"
        info += "$isSleeping\n"
        info += "$isHungry\n"
        info += "$bff"

        return info
    }


}

class Room(val width: Int, val height: Int, val depth: Int) {
    // Method to calculate volume using the class properties
    fun volume(): Int {
        return width * height * depth
    }
    fun interiorArea(): Int {
        // Calculate the area of the four walls and floor/ceiling
        return 2 * (width * height + height * depth + width * depth)
    }
}