package lectures.part3fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)


  // map
  println(list.map(_ + 1)) // 2-3-4
  val myFn = new Function1[Int, Int] {
    override def apply(x: Int): Int = x + 50
  }

  println(list.map(f)) // 1-4-9

  println(list.map(_ + " is a number"))
  val numbers = List(1, 2, 3, 4)

  println(list.map(myFn))

  // filter
  println(list.filter(x => x % 2 == 0)) // filter our even only, 2 expected

  // flatMap
  println(list.flatMap(x => List(x, x * x))) // converts every element of list to List with 2 elems.
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("red", "green")
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  // in this way we are doing "iterations". As in imperative languages you're implementing in this way:
  // cycle > inner cycle > deepest inner cycle
  val combo = numbers.flatMap(n => chars.flatMap(c => colors.map(col => "" + n + "-" + c + "-" + col)))
  //  we are preparing flatMap of each element of numbers. FlatMap function takes number end return this number Map with
  //  any of chars
  //  so, instead of each number we are returning List prepared by MAP(it's a flatMap). 4 maps here.
  //  a1, b1, c1, d1 | a2, b2, c2, d2 | a3, b3, c3, d3 | a4, b4, c4, d4

  println(combinations)
  // for comprehensions. Way readable !
  val forCombinations = for {
    n <- numbers if (n % 2 == 0)
    c <- chars
    color <- colors
  } yield {
    "" + n + "-" + c + "-" + color
  }
  println(combo)

  // but flatmap > flatmap> map is a little bit confusing
  // because of this we have "for comprehensions", to make this way readable

  def f: (Int) => Int = (x: Int) => x * x

  println(forCombinations)


  // foreach
  println(colors.foreach(println))


  // list methods overloading. Example with map. Insetad of receiving map function, logic is provided directly
  println(numbers.map { x => x * 2 })


}
