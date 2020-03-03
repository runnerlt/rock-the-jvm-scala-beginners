package lectures.part3fp

object TuplesAndMaps extends App {

  // Tuples
  val t = new Tuple2[Int, String](2, "Hello Scala")
  println(t)
  println(t._1)
  println(t.swap)
  println(t.copy(_2 = "Bye Java"))

  val tuple: (Int, String) = (3, "Test") // Syntactic sugar

  println((1, "7878").getClass)

  // Maps
  val aMap: Map[String, Int] = Map()
  val bMap: Map[String, Int] = Map("Juozas" -> 666, "Dovile" -> 777).withDefaultValue(-1)
  println(bMap)

  println(bMap.contains("Juozas"))
  println(bMap("Dovile"))
  println(bMap("Dovilee")) // default executes

  // map, flatMap, filter
  println(bMap.map(pair => pair._1.toLowerCase() -> pair._2))
  println(bMap.filterKeys(x => x.startsWith("D"))) // (Dovile -> 777)
  println(bMap.mapValues(x => x * 10))

  println(bMap.head)
  println(bMap.toSeq)

  // Very interesting and used often in Spark: group By
  val lst: List[String] = List("juozas", "dovile", "jonas", "janina", "domas", "lukas", "rusne")

  println(lst.groupBy(name => name.charAt(0)))

  // Exercises:
  val m1: Map[String, Int] = Map("Juozas" -> 555, "JUOZAS" -> 666)
  println(m1.map(name => name._1.toLowerCase -> name._2)) // last List tuple only.. ??

}
