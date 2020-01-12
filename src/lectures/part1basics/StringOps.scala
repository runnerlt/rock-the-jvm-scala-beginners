package lectures.part1basics

object StringOps extends App {

  val str: String = "Mano didelis didelis namas tueri penkis langus."

  println(str.charAt(3))
  println(str.contains("didelis"))
  println(str.indexOf("namas"))
  println(str.split(" ").toList)
  println('A' +: str :+ 'C')


}
