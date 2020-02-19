package playground

object ScalaPlayground extends App {

  val numbers = List(1, 2, 3, 4, 5, 6)
  val chars = List('a', 'b', 'c', 'd', 'e', 'f')
  val colors = List("Red", "Yellow", "Blue")

  val combo1 = numbers.flatMap(n => chars.flatMap(c => colors.map(col => n + "-" + c + "-" + col)))
  println(combo1);

  val combo2 = for {
    n <- numbers if (n % 2 == 0)
    c <- chars
    col <- colors
  } yield n + "-" + c + "-" + col

  println(combo2)

  val f = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(f(4, 5))

  val f2: (Int, Int, Int) => Int = (x, y, z) => x * y * z
  println(f2(8, 6, 8))

  val f3: (Int) => (Int) => (Int) => Int = x => y => z => x * y * z
  println(f3(5)(6)(7))

  def f4(x: Int)(y: Int): Int = x * y

  println(f4(5)(2))

}