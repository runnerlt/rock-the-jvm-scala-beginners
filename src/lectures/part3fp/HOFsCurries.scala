package lectures.part3fp

object HOFsCurries extends App {

  // def nTimes(f, n, x) => f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne: Int => Int = (x: Int) => x + 1

  println(nTimes(plusOne, 5, 5))
  println(nTimes((x: Int) => x + 1, 5, 5))
  val plus10 = nTimesBetter(plusOne, 10) // returns lambda (x: Int) => f(f(...f(x)))

  // now not perform calc, but just return lambda to be used with any value X
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x // just identity function
    else (x: Int) => nTimesBetter(f, n - 1)(f(x)) // forms f(f(...f(x)))
  println(plus10, 1)

}
