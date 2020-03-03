package lectures.part3fp

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.++(Seq(5, 6, 7)))
  println(aSequence.sorted)


  // Ranges
  val aRange: Seq[Int] = 1 until 5
  println(aRange)

  println(aRange.tail)

  (1 to 5).foreach(x => println(x))
  val result = (1 to 5).map(x => x * x)
  println(result)

  // Lists
  val ls = List(1, 8, 2, 3)
  println(87 +: ls :+ 12)
  println(87 :: ls.sorted)

  val x = List.fill[String](5)("x8")
  println(x)

  println(ls.mkString(" | "))

  println("fdsff".mkString("-"))

  println(66 +: ls :+ 666)

  // Arrays

  val arr = Array(1, 5, 7, 8, 9)
  val arr2 = Array.ofDim[Int](4)
  arr2.foreach(println)

  arr(1) = -5

  println(arr.mkString(" | "))

  // Vectors
  val v = Vector(4, 6, 8, 5, 8, 555, 58, 7, 7)
  println(v.sorted)

  println("fsdf" + "aaaaa")


}
