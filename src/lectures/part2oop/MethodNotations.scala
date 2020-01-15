package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name wjat a heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name an I like movie $favoriteMovie"

    def unary_+(nick: String): Person = new Person(s"${this.name} (${nick})", this.favoriteMovie)

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def learns(discipline: String): String = s"${this.name} learns $discipline"

    def learnScala: String = this.learns("Scala")

    def apply(times: Int): String = s"${this.name} watched movie ${times} times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fighting club")
  println(mary hangoutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  val x: Int = -1
  val y: Int = 1.unary_-
  println(x == y)

  println(!mary)
  println(mary.unary_!)

  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary())

  println(mary.apply() == mary())

  /**
   * Exercises
   *
   * 1 overload + operator (accepts String)
   * returns a new person with nickname
   * example:
   * mary + "the rock star" => new person "Mary (the rock star)"
   *
   * 2 add the age to person class with default 0
   *
   * 3 add "learns" method to Person class
   * receives string parameter and returns string
   * "Mary learns {Scala"}
   *
   * add learnsScala method, parameterless, calls learns method
   * with a "Scala" as parameter
   * Use it with a postfix notation
   *
   * 4 overload apply method to receive number and
   * return a String
   * example: mary.apply(2) =>
   * "Marie watched {Inception} 2 times
   */
  println(mary.unary_+("the rock star").name)
  println(mary.unary_+.age)

  println(mary.learns("math"))
  println(mary learns "ScalaX")
  println(mary.learnScala)

  println(mary(3))
}
