package lectures.part2oop

object Generics extends App {

  val myIntList = MyList.empty[Int];

  class MyList[A] {

  }

  object MyList {

    def empty[A]: MyList[A] = new MyList[A]

  }

}
