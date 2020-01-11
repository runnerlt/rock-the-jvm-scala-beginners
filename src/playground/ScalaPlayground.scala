package playground

object ScalaPlayground extends App {
  println("Hello, Scala!")

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8))


  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def primeExtended(acc: Int): Int = {
      if (acc == 0 || acc == 1) -1 // handle zero, one. They are not primes.
      else if (n % acc == 0) n / acc
      else primeExtended(acc - 1)
    }

    if (primeExtended(n / 2 ) == n) true
    else false

  }

  println("Is prime: " + isPrime(0))


}

