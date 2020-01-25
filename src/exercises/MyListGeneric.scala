package exercises

/**
 *
 */
object MyListGeneric extends App {

  val intList: MyListNotEmpty[Int] = new MyListNotEmpty[Int](5, MyListEmpty)
  println(intList.head())
}

/**
 *
 * @tparam A
 */
abstract class MyList[+A] {
  def head(): A

  /*
    def tail[A](): MyList[A]

    def isEmpty(): Boolean

    def add[A](item: A): MyList[A]

    def printElements: String

    override def toString: String = "[" + printElements + "]"
    */

}

object MyListEmpty extends MyList[Nothing] {
  override def head() = throw new NoSuchElementException
}

class MyListNotEmpty[A](h: A, t: MyList[A]) extends MyList[A] {
  override def head(): A = h
}