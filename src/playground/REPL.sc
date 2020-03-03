val s = Seq(1, 5, 7, 1, 2, 3, 6, 5)

println(s.mkString(" - "))

println(s.sorted.mkString(" | "))

println(55 +: s :+ 66)
val l = List.fill[String](5)("x").mkString(" | ")

def a = Array.ofDim[Int](5)
