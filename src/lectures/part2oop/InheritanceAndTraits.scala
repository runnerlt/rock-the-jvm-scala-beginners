package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal(private val weight: Int, height: Int) {
    def this(height: Int) = this(4, height)

    def eats(): String = "Animal eats"

    protected def runs(): String = "Animal runs"
  }

  class Cat(name: String, age: Int) extends Animal(height = 3) {
    println("im instantiating: cat")

    def catEats(): String = {
      println("inside catEats method")
      eats()
      runs()
    }

    def eats(qty: Int): String = "Im eating from Cat"

    override def eats(): String = "Im eating from Cat overidded"

    println(weight)
  }

  val c = new Cat("Kice", 10)

  println(c.eats())
//  println(c.weight)

  //  println(c.catEats())
  //  println(c.runs())


}
