package exercises

object lesson24functions extends App {

  val adder3 = superAdder(3)

  println(concatenator("labas", " rytas"))

  //  let say, return type will be:
  // Function1[Int, Function1[Int, Int]]

  def concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }

  def superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(adder3(4))
  println(superAdder(3)(8)) // after returning functuion calling it again. this calles CURRIED function

}
