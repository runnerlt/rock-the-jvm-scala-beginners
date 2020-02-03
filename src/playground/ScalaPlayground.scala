package playground

object ScalaPlayground extends App {

  def concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }

  println(concatenator("labas", " rytas"))

}


