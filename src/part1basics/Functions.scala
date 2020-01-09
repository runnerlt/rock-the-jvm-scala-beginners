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

  def fibonacci(n: Int): Int = {
    // TODO: pabaigti
    1
  }

}
