package playground

object ScalaPlayground extends App {
  val fn3 = (x: Int) => x * 9

  def fn(x: Int): Int = x * x

  def fn2 = (x: Int) => x * 9

  println(fn2.apply(6))
  println(fn3.apply(5))


  def test: (Int, Int) => Int = (x, y) => x * y

  def t = (x: Int) => (y: Int) => x * y

  def triple = (x: Int) => (y: Int, y2: Int) => (z: Int) => x * y * y2 * z

  println(triple(2)(3, 5)(4))

  def testas: (Int) => Int = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 5
  }


}


