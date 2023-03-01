object ObjectOrientation extends App {
  //class definition
  class Animal{
    //this is a field of animal
    val bornDay=12/10/900
    val age:Int=10
    //this is a method of animal
    def eat(food: String): String = {
      s"eating $food"
    }
  }
  //this is how a class can be instanced
  val anAnimal = new Animal
  println(anAnimal.age)

  //Inheritance:
  //The constructor is defined adding the parameters that will receive, but them are not fields (can't be accessed)
  //To indicate fields, we can use 'var'
  class Dog (var name:String,race:String="chihuahua")//chihua será el nombre por defectos i no se inidca otro
    extends Animal {
    override def toString:String={
      s"$name - $race"
    }
  }//extends from animal class
  val aDog = new Dog("quiajito","Husky")
  println(aDog.name)//race can't be accessed

  //subtype of polymorphism
  val aDeclaredAnimal: Animal = new Dog("ferras","golden retriever")
  println(aDeclaredAnimal.eat("meat"))//the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal{
    private var typeOfNails = "garras"//only the clas can access to this parameter
    protected var resistence:Int=100//Only the class and its descendant can access
    val hasLegs = true//public
    def walk():Unit//public funtion
    def wayOfWalf():String={s"camina usando $typeOfNails, además tiene una resistnecia de $resistence"}//public function
  }
  //instance od an abstract class
  val centipede = new WalkingAnimal {
    override def walk(): Unit = {
      println("walking in the floor with ")
    }
  }
  println(centipede.hasLegs)
  println(centipede.walk())
  println(centipede.wayOfWalf())

  //interface is the ultimate abstract class
  trait Carnivore{
    def eat(animal: Animal):String
  }

  //single class inheritance or multi-trait "mixing"
  class Crocodrile extends Animal with Carnivore{
    override def eat(animal: Animal): String ={s"the crocodile is eating $animal"}
    override def eat(food: String): String = super.eat(food)
  }
  //instance od a crocodile class
  var aCrocodrile = new Crocodrile
  //using the overrided function using another animal
  println(aCrocodrile.eat(aDeclaredAnimal))
  //using the parent eat function
  println(aCrocodrile eat   "zebra")//we can use this sintaxis whith methods wit only on arg

  //singlenton onbject is like an static object
  object Animal{//when a object has the same name that a class are called as companions, companion object and companion class
    //companions can access each other's private fields and methods
    //the singleton companion object is diferent that instances of class companion
    var age = 67 //defining a normal var
    def applyBirthday(){age+=2}
    def apply(newAge: Int) = {
      age = newAge
    }

  }
  println(Animal.age)

  Animal.applyBirthday()//se le suma uno a la edad
  println(Animal.age)

  Animal.apply(0)//le mandamos un valor a la función apply
  println(Animal.age)

  Animal apply 14// otra forma de llamar a apply
  println(Animal.age)

  Animal(115) // otra forma de llamar a apply
  println(Animal.age)

  /*
  case class: ligthweight data structure with some boilerplate (repetotivo)
  - sensible equals and hash code
  - serialization
  - companion with apply
  - áttern matching
   */
  case class Person (name:String,age:Int)

  //may be constructed without 'new'
  val jhon = Person("jhon Doe",25)


  /*
  Exceptions
  exception-throw
   */
  try{
    val x: String=null
    println(x.length)
  }catch {
    case e: Exception=> {
      println("Something went wrong")
    }
  }finally {
    println("closing database connection")//will be executed no matter what
  }

  /*
  generic:
   */
  abstract class MyList[T]{
    def head: T
    def tail:MyList[T]
  }

  val aList: List[Int] = List(1,2,3)
  val first = aList.head
  println(first)
  val others = aList.tail
  println(others)
}