import scala.annotation.tailrec

object HelloWorld {
  def main(args: Array[String]): Unit = {

    println(s"Command line arguments: ${args.toList}")
    println(s"Grouped command line arguments: ${args.toList.grouped(2).toList}")

    case class Person(name: String, age: Int)
    val people = args.grouped(2).map { pair =>
      val name = pair(0)
      val age = pair(1).toInt

      Person(name, age)
    }.toList

    val kids = people.filter(p => p.age < 12)
    val norm = people.filter(p => p.age >= 12 & p.age <= 60)
    val elders = people.filter(p => p.age > 60)

    println(s"People: ${people}")
    println(s"Kids: ${kids}")
    println(s"Norm: ${norm}")
    println(s"Elders: ${elders}")

    val byAge = people.sortBy(_.age)

    println(s"People sorted by age: ${byAge}")


    //////////////////////////     2      ///////////////////////

    def fib(n: Int): Int = {
      if (n<=0) 1
      else {
        fib(n-1)+fib(n-2)
      }
    }
    println(fib(0))
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(4))
    println(fib(5))
    println(fib(6))
    println(fib(7))


    def fib1(n: Int): Int= {
      @tailrec
      def rec(n: Int, acc: Int, acc1: Int):  Int = {
        if (n <= 0)  acc
        else rec(n - 1, acc1, acc1+acc)
      }
      rec(n, acc=1, 1)
    }
    println(fib1(0))
    println(fib1(1))
    println(fib1(2))
    println(fib1(3))
    println(fib1(4))
    println(fib1(5))
    println(fib1(6))
    println(fib1(7))


    lazy val fib3: Stream[Int] = 1 #:: 1 #:: (fib3 zip fib3.tail map { case (a, b) => a + b })
    println(fib3.take(10).toList)
  }
}


////////////////////////////    3     ///////////////////////
sealed trait Expr

case class Var(value: Int) extends Expr

sealed trait Op extends Expr
case class Mul(a: Expr, b: Expr) extends Expr
case class Sum(a: Expr, b: Expr) extends Expr

def show(expr: Expr): String = expr match {
  case Var(i) => i.toString
  case Mul(a, b) =>"(" + show(a) + "*" + show(b) +  ")"
  case Sum(a, b) =>"(" + show(a) + "+" + show(b) +  ")"
}
val expr = Mul(Var(3), Sum(Var(2), Var(1)))
show(expr)
def eval(expr: Expr): Int = expr match {
  case Var(i) => i.toInt
  case Mul(a, b) => eval(a) * eval(b)
  case Sum(a, b) => eval(a) + eval(b)
}
eval(expr)

