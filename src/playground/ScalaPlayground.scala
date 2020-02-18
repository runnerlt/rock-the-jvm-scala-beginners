package playground

object ScalaPlayground extends App {

  val vilnius = new Place(new Vilnius)
//  val world = new Place(new World)

}


class World

class Europe extends World

class Lithuania extends Europe

class Vilnius extends Lithuania

class Germany extends Europe

class Place[A >: Vilnius <: Europe](val p: A) {}


