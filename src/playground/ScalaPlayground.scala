package playground

object ScalaPlayground extends App {

  val numbers = List(1, 2, 3, 4, 5, 6)
  val colors = List("red", "yellow", "green")
  println(numbers.flatMap(x => x + "okey"))

  println(numbers.map(_ + 8))

  numbers.map(println(_))

  val compr = for {
    n <- numbers
  } yield {
    n * Math.PI
  }

  println(compr)


}