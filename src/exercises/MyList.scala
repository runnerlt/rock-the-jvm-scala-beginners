package exercises

/**
 *
 */
object MyListGeneric extends App {
  val intList: Cons[Int] = new Cons(5, Empty)
  println(intList.head())
  println(intList.toString())
}

abstract class MyList[+A] {
  def head(): A

  def tail(): MyList[A]

  def isEmpty: Boolean

  def add[B >: A](item: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList[Nothing] {
  override def head(): Nothing = throw new NoSuchElementException

  override def tail(): MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](item: B): MyList[B] = new Cons(item, Empty)

  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head(): A = h

  override def tail(): MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](item: B): MyList[B] = new Cons(item, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}