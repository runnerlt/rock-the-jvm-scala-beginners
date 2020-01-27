package lectures.part2oop

object AnonymousClasses extends App {

  val a = new Auto {
    override val x: Int = 8
    override def ride(): String = "Im riding"
  }
  val f = new House(8){
    override def getFloors: Int = super.getFloors + 6
  }

  println(a.ride())

  trait Auto {
    val x: Int
    def ride(): String
  }

  class House(floors: Int) {
    def getFloors: Int = floors
  }

  println(f.getFloors)

}
