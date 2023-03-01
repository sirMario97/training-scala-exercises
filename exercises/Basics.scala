import scala.collection.immutable.Range

object Basics extends App {
  //defining a value
  val meaninOfLife: Int = 42 //constante, no cambia
  println(meaninOfLife)

  var valueThatChanges = "holi"
  valueThatChanges="adio"
  println(valueThatChanges)

  //Int, Boolean, Char, Double, Float, String
  val aBoolean = false//it doesnt need the type of the var
  println(aBoolean)

  //string operations
  val aString = "holiwis"
  println(aString)
  val aComposedString = "holiwis"+". This is a "+" composed string"
  println(aComposedString)
  val anInterpolatedString = s"scala says: $aComposedString with an inserted valued that is: $meaninOfLife"
  println(anInterpolatedString)

  //expresions are structures that can be reduced to a value
  val aSumExpresion = 2+3
  println(aSumExpresion)
  val ifExpresion = if (meaninOfLife>40) true else false
  println(ifExpresion)
  val chainedIfExpresion =
    if (meaninOfLife > 30) -56 //esto es lo primero que va aregresar
    else if (meaninOfLife <100) true
    else if(meaninOfLife==42)false
    else 0
  println(chainedIfExpresion)

  //code blocks
  var aCodeBlock={
    //definitions
    val aLocalValue="es una variable local"
    aLocalValue+3//the last value is te value of the expresion, like a return
    println(aLocalValue)
  }
  aCodeBlock //Executing the code insed the var which contains a code block inside

  //define a func
  def myFunc(x: Int, y:String):String={
    y+" - "+x
  }
  println(myFunc(97,"Edna nació el año del"))

  //recursive function. In SCALA we don't use loops or iterations, RECURSION instead
  def factorial(n:Int): Int=
    if(n<=1)1 else n * factorial(n-1)
  println(factorial(6))

  //Unit type = (no meaingful value) = void (java) = None (python)
  //type of SIDE EFECTS
  println("I still love SCALA")

  //returnin Unit
  def myUnitReturningFunction():Unit={
    println("This is a wierd value")
  }

  //Unit type returned from a function asigned to a var
  var varUnit = myUnitReturningFunction()//call to the fun and setting the value in a var
  println(varUnit)

  //Unit type directly assigned to a var
  val theUnit = ()
  println(theUnit)
}
