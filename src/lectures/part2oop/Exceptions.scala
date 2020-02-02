package lectures.part2oop

object Exceptions extends App {

  val potentialFailure = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Im caught and fixed Runtime exception")
  } finally {
    println("Im still finishing")
  }
  val exception = MyException()

  def getInt(isException: Boolean): Int =
    if (isException) throw new RuntimeException("Ups, not a Int")
    else 42

  case class MyException() extends Exception

  throw exception

}
