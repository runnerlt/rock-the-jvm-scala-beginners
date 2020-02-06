package lectures.part3fp

object AnonymousFunctions extends App {

  def crap: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(crap.apply(4, 5))


  def oky: (Int, Int) => Int = _ * _

  println(oky(5, 8))
}
