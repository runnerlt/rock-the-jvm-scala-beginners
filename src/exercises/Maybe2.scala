package exercises

abstract class Maybe2[+T] {
  def map[B](f: T => B): Maybe2[B]

  def flatMap[B](f: T => Maybe2[B]): Maybe2[B]

  def filter(p: T => Boolean): Maybe2[T]

}

object MaybeEmpty extends Maybe2[Nothing] {
  override def map[B](f: Nothing => B): Maybe2[B] = MaybeEmpty

  override def flatMap[B](f: Nothing => Maybe2[B]): Maybe2[B] = MaybeEmpty

  override def filter(p: Nothing => Boolean): Maybe2[Nothing] = MaybeEmpty
}

case class MaybeSingle[+T](value: T) extends Maybe2[T] {
  override def map[B](f: T => B): Maybe2[B] = MaybeSingle(f(value))

  override def flatMap[B](f: T => Maybe2[B]): Maybe2[B] = f(value)

  def filter(p: T => Boolean): Maybe2[T] =
    if (p(value)) this // if predication function call on single list element returns true, return THIS object
    else MaybeEmpty // else return empty object

}