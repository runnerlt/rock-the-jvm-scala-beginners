package lectures.part2oop

object AbstractDataTypes extends App {

  val f = new Fiat()

  /**
   * Racing car trait
   */
  trait RacingCar {
    def driveFast(): String

    def driveTurbo(): String = "Im driving turbo"
  }

  /**
   * Abstract implementation of car
   *
   * @param color each car must have a color
   */
  abstract class Car(color: String) {
    val mileage: Int

    def getMileage: Int
  }

  class Fiat extends Car("red") with RacingCar {
    override val mileage: Int = 50000

    override def getMileage: Int = this.mileage

    override def driveFast(): String = "Im driving fast!"
  }

  println(f.mileage)
  println(f.driveFast())
  println(f.driveTurbo())

}
