package playground

object ScalaPlayground extends App {

  val animalList: MyList[Animal] = MyList.empty[Dog]

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  class MyList[+A] {

  }

  object MyList {
    def empty[A] = new MyList[A]()
  }

  //  val catList: MyList[Cat] = MyList.empty[Animal]


}


