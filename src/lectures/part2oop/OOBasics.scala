package lectures.part2oop

import java.time.Year

object OOBasics extends App {

  val w = new Writer("Juozas", "Alsevskis", 1984)
  println(w.fullName())

  val n = new Novel("Novele", 1990, w)
  println(n.authorAge())
  println(n.isWrittenBy())
  val copied = n.copy()
  println(copied.authorAge())

  // testing of counter
  val c = new Counter(3)
  println(c.getCnt())
  println(c.inc().getCnt())
  println(c.dec().getCnt())
  println(c.dec(5).getCnt())
  println(c.inc(5).getCnt())

  /*
  val c = new Car("Fiat", "Red", 50000)
  val g = new Car()
  println(c.color)
  println(g.wheels)
  g.drive("green")
  */
}

class Car(model: String, val color: String, mileage: Int) {
  def this() = this("Fiat", "Govno", 0)

  val wheels: String = "awd"

  def drive(color: String): Unit = println(s"Car color is ${this.color}  and I like color $color")
}


// Exercises
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.year

  def isWrittenBy(): String = author.fullName()

  def copy(): Novel = new Novel(name, Year.now.getValue, author)
}

class Counter(counter: Int) {
  def getCnt(): Int = this.counter

  def inc(): Counter = new Counter(counter + 1)

  def dec(): Counter = new Counter(counter - 1)


  def inc(n: Int): Counter = {
    println(s"We have b in icrement: ${n}")

    if (n < 1) this
    else inc.inc(n - 1)

  }

  def dec(n: Int): Counter = {
    println(s"We have b in decrement: ${n}")

    if (n < 1) this
    else dec.dec(n - 1)

  }

}


