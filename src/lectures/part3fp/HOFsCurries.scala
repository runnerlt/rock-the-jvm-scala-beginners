package lectures.part3fp

object HOFsCurries extends App {

  // def nTimes(f, n, x) => f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne: Int => Int = (x: Int) => x + 1

  //  println(nTimes(plusOne, 5, 5))
  //  println(nTimes((x: Int) => x + 1, 5, 5))
  val plus10 = nTimesBetter(plusOne, 10) // returns lambda (x: Int) => f(f(...f(x)))

  // now not perform calc, but just return lambda to be used with any value X
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x // just identity function
    else (x: Int) => nTimesBetter(f, n - 1)(f(x)) // forms f(f(...f(x)))

  println(plus10(1))

  def standardFormat: (Double) => String = curriedFormatter("%10.3f")

  // main advantage using HOFs and Curried functions is, that we can
  // provide multiple parameter list. And, then implement functions (which uses these params)
  //  step by step.
  // I MEAN:
  // implement function1 using first parameter list (x), and then you able to call function1(y), and your
  //  curriedFormatter logic will be triggered
  // something like implementing all defined parameter lists step - by -step
  def curriedFormatter(x: String)(y: Double): String = x.format(y)

  def preciseFormat: (Double) => String = curriedFormatter("%10.6f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // or you are allowed to call straightway:
  println(curriedFormatter("%20.8f")(Math.PI))

  def fx = (x: Int) => (y: Int) => (x + y)

  def fx2(x: Int)(y: Int): Int = x * y

  println(fx(5)(8))
  println(fx2(4) _)


}
