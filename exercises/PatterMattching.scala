object PatterMatching extends App {
  /*
  SWITCH EXPRESION
   */
  val anInt= 55
  var order = anInt match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => s"$anInt th"
  }
  println(order)
  //pattern matching is an expression
  case class Person(name: String, age: Int)
  val bob = Person("Bobi",30)//person apply
  val personGreeting = bob match {
    case Person(n,y)=>s"Hi, im $n and im $y years old"
    case null => "not defined"
  }
  println(personGreeting)

  //PM can deconstruct tuples
  val aTuple = ("Octavio","Ingeniero")

  val professionDescriptions = aTuple match {
    case (name,profession)=>s"$name es un $profession"
    case null => "No definido"
  }
  println(professionDescriptions)

  //decomposing a list
  val aList = List(1,2,3)

  var listDesc = aList match {
    case List(_, 2,_) => "List containg 1 and 2 at the first two elements"
    case _ => "No defined"
  }
  println(listDesc)
}

