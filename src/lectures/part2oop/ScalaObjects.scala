package lectures.part2oop

object ScalaObjects extends App {


  val pp = Person("Kostas")
  println(pp.talkClass())
}

object Person {
  val name: String = "Juozas"
  val age: Int = 35

  def talk(): String = s"My name is $name"

  def apply(name: String) : Person = new Person(name, age)

}

class Person(name: String, age: Int) {
  def talkClass(): String = s"Ok, Im $name and my age is ${Person.age}"
}
