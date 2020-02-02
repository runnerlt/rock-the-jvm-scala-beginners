package exercises

object ExceptionsExercises extends App {

  // 1
  //  throw new OutOfMemoryError()

  // 2
  //  throw new StackOverflowError()

  val calc = PocketCalculator()

  class OverflowException extends Exception

  class UnderflowException extends Exception

  class MathCalculationException extends Exception("Divide by zero exception")

  case class PocketCalculator() {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x >= 0 && y >= 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Double = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  //  calc.divide(4, 0)
  calc.multiply(8, -2)

}
