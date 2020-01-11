package playground

object ScalaPlayground extends App {
  println("Hello, Scala!")

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8))


  def prime(n: Int): Int = {
    def primeExtended(n: Int, acc: Int): Int = {
//      println("n" + n + " acc " + acc)
      if (n % acc == 0) n / acc
      else primeExtended(n, acc - 1)
    }

    if (primeExtended(n, n - 1) == n) 1
    else 0

  }

  println("Is prime: " + prime(6))


}

