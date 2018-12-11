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

    def fact(n: Int): Int = {
      if (n<=0) 1
      else {
        fact(n-1)+fact(n-2)
      }
    }
    println(fact(0))
    println(fact(1))
      println(fact(2))
      println(fact(3))
      println(fact(4))
      println(fact(5))
      println(fact(6))
      println(fact(7))

  }
}

