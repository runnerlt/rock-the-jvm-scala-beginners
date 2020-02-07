package lectures.part3fp

object HOFsCurries extends App {

  val plusOne = (x: Int) => x + 1

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  println(nTimes(plusOne, 5, 1))

}
