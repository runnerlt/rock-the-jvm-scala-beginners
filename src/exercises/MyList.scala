package exercises

import javafx.collections.transformation.SortedList

abstract class MyList[+A] {
  def head(): A

  def tail(): MyList[A]

  def isEmpty: Boolean

  def add[B >: A](item: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  // higher order functions. Receives functions as params OR returns other functions ar result
  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  //  concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

}

case object Empty extends MyList[Nothing] {
  override def head(): Nothing = throw new NoSuchElementException

  override def tail(): MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](item: B): MyList[B] = new Cons(item, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //hofs
  override def foreach(f: Nothing => Unit): Unit = () // the same, as Unit
  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head(): A = h

  override def tail(): MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](item: B): MyList[B] = new Cons(item, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  /** Performs transformation on linked list MyList
   * Takes type B as parameter (target type of MyList to be returned)
   * Transforms HEAD position, and calls self recursively on the TAIL to transform all remaining elements of tail
   * And of course: all this recursion result is wrapped into a new Cons object of return type B
   *
   * @param transformer MyTransformer type with a transform():B method from A to B
   * @tparam B - type of MyList to be returned
   * @return linked list MyList of type B
   */
  def map[B](transformer: A => B): MyList[B] = {
    //    new Cons(transformer.apply(h), t.map(transformer))
    new Cons(transformer(h), t.map(transformer))
  }

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /** Performs filtering on linked list MyList
   * checks of HEAD meets criteria, if yes - returns new Cons object with this head and recursively calling
   * self on the tail.
   * If head does not meets criteria, just calling recursively self on the tail
   *
   * @param predicate of type MyPredicate[A] with method test: boolean
   * @return MyList of type A, filtered by predicate
   */
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  // helper method to concatenate current list with given list
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ (list))


  // hofs
  override def foreach(f: A => Unit): Unit = {
    f(h) // becomes println(h). And this one always print head.
    t.foreach(f) // this is just for recursion. No any printing actions here
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    //  helper function
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head()) <= 0) new Cons(x, sortedList) // jeigu head mazesnis uz rikiuoto listo head
      else new Cons(sortedList.head(), insert(x, sortedList.tail())) // kitu atveju esamas head, o likusi list perrikiuojam
    }

    val sortedTail = t.sort(compare) // per tail naudojam fn paduodamami savo compare formule/lambda
    insert(h, sortedTail) // insert funkcija ideda head i sortedTail. Ir i reikiama pozicija.


  }
}

object MyListGeneric extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))

  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString())

  println(listOfIntegers.map((elem: Int) => elem * 2))

  println(listOfIntegers.filter((elem: Int) => elem % 2 == 0))

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap((elem: Int) => new Cons(elem, new Cons[Int](elem + 1, Empty))))

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))

}

