package playground

object ScalaPlayground extends App {

  def fn: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(elem1: Int, elem2: Int): Int = elem1 * elem2
  }

  println(fn(5, 8))


}


