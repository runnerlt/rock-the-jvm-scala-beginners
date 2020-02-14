val p1: Parking[Vehicle] = Parking[Car](new Car)

sealed abstract class Vehicle

case class Car() extends Vehicle

case class Motorcycle() extends Vehicle

case class Parking[+A](value: A)

p1.value.getClass()


