package lectures.part2oop

object MethodNotations extends App {

  class Person(name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
  }

  val juozas = new Person("Juozas", "Rambo 3")

  println(juozas likes "Rambo 3")
  println(1.+(2))

}
