fun main() {
    val cat1 = Cat("Tom")
    val cat2 = Cat("mike", 3)
    println(cat1)
    println(cat2)

    cat1.poke()
    cat2.pet()
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