package exercises


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

  // signatures of map, flaytMap, filter
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

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

// traits predicate, MyTransformer
trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}