object Functionalrograming extends App {
  //scala is a OOP
  class Person(name:String){
    def apply(age:Int)=println(s"The age of $name is $age years")
  }

  val bob = new Person("bob")
  bob(43)


  /*
  Func Prog in SCALA:
  - composed by functions
  - pass functions as args
  - return functions as results
   */

  val simpleFunc = new Function[Int,Int] {
    override def apply(arg: Int): Int = 3*arg
  }
  //the call of the default method of the function od one argument
  println("normal way: "+simpleFunc(3).toString)

  val concatenator = new Function3[String, String, String, String] {
    override def apply(arg: String, arg2: String, arg3: String): String = s"this is the $arg, the second is: $arg2, and the third one is: $arg3"
  }
  //calling the function with 4 params
  println(concatenator("firs argument","chale","asumaquina"))

  //sintax suggar (make simpler)
  //This sintaxys is easier than the one usde in simpleFunc
  val simpleFuncSuggared: Function1[Int,Int]=(x:Int)=>2*x
  println("sugared: "+ simpleFuncSuggared(3).toString())

  //other sintax suggar (make simpler)
  //This sintaxys is easier than the one usde in simpleFuncSuggared
  val simFuncSug: Int => Int = (x: Int) => 2 * x
  println("more sugared: "+simFuncSug(3).toString())

  //other sintax suggar (make more and more simpler)
  //This sintaxys is easier than the one usde in simFuncSug
  val superSimpleSuggarFunc = (x: Int) => 2 * x
  println("the most sugared: " + superSimpleSuggarFunc(3).toString())

  /*
  High Order Functions: recives afunction as parameter or/and returns a function
   */
  //For each number 'x' will sum one and make a new list with the result of all sums
  val mappedList: List[Int] = List(1,2,3).map(x => x+1)
  println(mappedList)

  //flatmap creates a list combining sub lists
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x,x*2))
  println(aFlatMappedList)

  //filtering a list
  val aFilteredList = List("Uno","dos","pepe").filter(_.equals("pepe"))//the '_' means 'x => x'
  println(aFilteredList)

  //creating a new list
  val pairs = List(1,2,3).flatMap(number=>List('a','b','c').map(letter=>s"$number$letter"))
  println(pairs)

  //creating a new list of lists [1,2,3] * [a,b,c]
  val pairUsingFor = for{
    number <- List(1,2,3)
    letter <- List('a','b','c')
  }yield List(number.toString,letter)
  println(pairUsingFor)

  /*
  COLLECTIONS
   */

  val aList = List(1,2,3,4,5)
  println("first element: "+aList.head)
  println("rest of elements: "+aList.tail)
  val newList1 = 0::aList//adding a element at the beginning
  println(newList1)
  val newList2 = aList:+6//adding one element at the end
  println(newList2)
  val newList3 = 0+:aList:+6//adding at the top and the bottom
  println(newList3)

  //sequences
  val aSequence=Seq("perro","gato","perico")
  println(aSequence(0))

  //vector is fast than seq
  val aVector = Vector("perro","gato","perico","pez","araña","serpiente","planta","araña")
  println(aVector.last)

  //SETS doest allows duplicates
  val aSet =Set(1,8,3,4,4,5,2)
  println(aSet.contains(2))
  println(aSet+6)
  println(aSet-8)

  //ranges
  val aRange = 1 to 1000
  println(aRange)
  val twoByTwo = aRange.map(x=>2*x).toList
  println(twoByTwo)

  //tuples values under the same value
  val aTuple=("perro","gatito",300)
  println(aTuple)

  //maps
  val aMapOfPhones: Map[String,Int] = Map(
    ("Daniel",49279522),
    ("Jane",304898032),
    "mario"->3420992
  )
  println(aMapOfPhones)

}
