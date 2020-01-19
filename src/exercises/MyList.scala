package exercises

abstract class MyList {
  def head(): Int

  def tail(): MyList

  def isEmpty(): Boolean

  def add(item: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head(): Int = throw new NoSuchElementException

  override def tail(): MyList = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

  override def add(item: Int): MyList = new Cons(item, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head(): Int = h

  override def tail(): MyList = t

  override def isEmpty(): Boolean = false

  override def add(item: Int): MyList = new Cons(item, this)

  override def printElements: String = {
    if (t.isEmpty()) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(3, new Cons(4, new Cons(5, Empty)))
  println(list.tail().head())
  println(list.tail.head)
  println(list.tail.tail.head)
  println(list.add(8).head)
  println(list.isEmpty())
  println(list.toString)
}

