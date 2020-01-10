package part1basics

object Functions extends App {

  def pr(name: String, age: Int): Int = {
    println("My name is " + name + " and aim " + age)
    1
  }

  pr("Juozas", 35)

  def fact(n: Int): Int = {
    def factInner(n: Int, acc: Int): Int = {
      if (n == 1) acc
      else acc * n * factInner(n - 1, acc)
    }

    factInner(n, 1)
  }

  println(fact(4))

  def fib(n: Int): Int = {
    if (n <= 2) 1
    else + fib(n - 1) + fib(n - 2)
  }
  println(fib(6))
}