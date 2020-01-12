package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def concat(str: String, n: Int): String = {
    @tailrec
    def cc(n: Int, acc: String): String = {
      if (n <= 1) acc
      else cc(n - 1, acc + str)
    }

    cc(n, str)

  }

  println(concat("Namas", 8))


  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def primeExtended(acc: Int): Int = {
      if (acc == 0 || acc == 1) -1 // handle zero, one. They are not primes.
      else if (n % acc == 0) n / acc
      else primeExtended(acc - 1)
    }

    if (primeExtended(n / 2) == n) true
    else false

  }

  println("Is prime: " + isPrime(0))


  def fib(n: Int): Int = {
    @tailrec
    def fibInner(i: Int, last: Int, prevLast: Int): Int = {
      println("i: " + i + " last: " + last + " prevLast: " + prevLast)
      if (i == 1) 0
      else if (i == 2 || i == 3) 1
      else if (i == 4) last + prevLast
      else fibInner(i - 1, last + prevLast, last)
    }

    fibInner(n, 1, 1)
  }

  println(fib(10))
  // 0 1 1 2 3 5 8 13 21 34
}
