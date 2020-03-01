package playground

object ScalaPlayground extends App {

  val v1: Holder[Europe] = new Holder[Europe](new Europe())
  val v2: Holder[Europe] = new Holder[Lithuania](new Vilnius())
  val v3: Holder[Europe] = new Holder[Vilnius](new Vilnius())

  class Holder[+A](val place: A);
  //  val v4: Holder[Europe] = new Holder[America] (new Usa())


}


class Universe {}

class Earth extends Universe {}

class Europe extends Earth {}

class Lithuania extends Europe {}

class Vilnius extends Lithuania {}

class America extends Earth {}

class Usa extends America {}

class Nigeria {}



