package org.functionalkoans.forscala

import org.functionalkoans.forscala.support.KoanSuite

class AboutApply extends KoanSuite {
  koan("""The apply method is a magical method in Scala, it is a method that doesn't require you
      |to leave out the entire method name!""") {

    class Counter(val seed:Int) {
      def apply(n:Int) = new Counter(seed + n)
    }

    var a = new Counter(10)
    a = a.apply(20)
    a.seed should be (30)
    a = a(40) //Whoa! Look Ma! No apply!
    a.seed should be (70)
  }

  koan("""The apply method can also be used in singleton objects as well, in fact, it is the most common way
          to create a factory method in an object""") {
    class Employee (val firstName:String, val lastName:String) //private constructor!

    object Employee {
        def apply(firstName:String, lastName:String) = new Employee(firstName, lastName)
        def apply(firstName:String) = new Employee(firstName, "Doe")
    }

//    var a = Employee.apply("Aleksander", "Neufied")
//    a.firstName should be ("Aleksander")
//    val b = Employee("Jamie", "Pindar")
//    a.lastName should be ("Pindar")
    val c = Employee("Robert")
    c.lastName should be("Doe")
  }
}
