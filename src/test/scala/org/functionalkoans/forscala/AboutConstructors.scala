package org.functionalkoans.forscala

import support.KoanSuite

class AboutConstructors extends KoanSuite {

  class AboutConstructorWithAuxiliaryConstructor(val name: String) {
    {
      info("Before constructor")
    }
    // invoke auxiliary constructor
    def this() {
      // what happens if you comment out the following line?
      this ("defaultname")
      info("In constructor")
    }

    def this(name:Int) {
      this(name.toString)
    }

  }

  koan("Primary constructor specified with a parameter requires that parameter to be passed in") {
    val aboutMe = new AboutConstructorWithAuxiliaryConstructor()
    val notPrimaryaboutMe = new AboutConstructorWithAuxiliaryConstructor(10)
    aboutMe.name should be ("defaultname")
    notPrimaryaboutMe.name should be ("10")
  }

  class AboutClassWithNoClassParameter

  koan("Class with no class parameters is called with no arguments") {
    // add parameter to make this fail
    val aboutMe = new AboutClassWithNoClassParameter

  }
}
