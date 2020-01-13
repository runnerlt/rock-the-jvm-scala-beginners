package playground

object ScalaPlayground extends App {
  println("Hello, Scala!")

  val c = new Counter(5)
  println(c.inc(8).getCnt)
  println(c.dec(80).getCnt)

}


class Counter(val counter: Int) {
  def getCnt: Int = this.counter

  def inc: Counter = new Counter(counter + 1)

  def dec: Counter = new Counter(counter - 1)


  def inc(n: Int): Counter = {
    println(s"We have b in icrement: $n")

    if (n < 1) this
    else inc.inc(n - 1)

  }

  def dec(n: Int): Counter = {
    println(s"We have b in decrement: $n")

    if (n < 1) this
    else dec.dec(n - 1)

  }


}

