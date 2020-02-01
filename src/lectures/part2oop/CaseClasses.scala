package lectures.part2oop

object CaseClasses extends App {

  // experiments with case classes and objects.
  // test all useful features

  val j = new Person("juozas", 35)
  val j2 = new Person("juozas", 35)
  val j3 = j.copy(age = 89)
  val pObj = Person("tom", 10)

  //  println(j.name)
  //  println(j == j2)
  //  println(j3)

  case class Person(name: String, age: Int) {
    println("just saying, that im executing on initialization")

    def intro(): String = {
      s"Im here with name $name"
    }
  }

  println(pObj)


}
