package syntax
// val
// def
// hof
// currying

object Main extends App {

  val number: Int = 1
  println(number)

  val unit = Unit

  def sum(a: Int, b: Int): Int = a + b
  println(sum(1,2))

  println(List(1,2,3).map(i => i * number))

  def sumCurried(a: Int)(b: Int)= a + b
  // a: Int -> b: Int -> Int
  val apply2: Int => Int = sumCurried(2)

  println(apply2(3))
  println(apply2(5))

}