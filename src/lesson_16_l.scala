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
  }
}

