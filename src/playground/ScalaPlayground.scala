package playground

object ScalaPlayground extends App {
  val sc = CarTemplate
  println(sc.drive)
  println(sc.carAttributesPrint)
  //  sc.addCarPart("wheels")

  val f = new Ferrari("Ferrari engine", CarTemplate)
  println(f.carAttributesPrint)
  println(f.addCarPart("vertical doors").carAttributesPrint)

}

abstract class Car {
  def drive: String

  def addCarPart(part: String): Car

  def listOfAttributes: String

  def carAttributesPrint: String = "[" + listOfAttributes + "]"
}


object CarTemplate extends Car {
  override def drive: String = "Im driving as standard car"

  override def addCarPart(part: String): Car = throw new NoSuchElementException

  override def listOfAttributes: String = "Slow horse"
}

class Ferrari(part: String, template: Car) extends Car {
  override def drive: String = "Im driving fast Ferrari"

  override def addCarPart(part: String): Car = new Ferrari(part, this)

  override def listOfAttributes: String = "Red, fast"
}