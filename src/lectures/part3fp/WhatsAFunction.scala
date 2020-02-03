package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(3) * 3)

  val triple = new ((Int) => Int) {
    override def apply(v1: Int): Int = v1 * 3
  }

  println(triple(4))

}


trait MyFunction[A, B] {
  def apply(element: A): B
}

