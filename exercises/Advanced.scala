import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  // lazzy evaluations, an expresion is not evaluated until its used
  lazy val aLazyValue = 2
  lazy val lazzyValueWithSideEffects={
    println("im so very lazzy")
    43
  }

  //lazy is useful for infinite collections
  val eagerValue = lazzyValueWithSideEffects+1
  println(eagerValue)

  //pseudo-collections: Option, Try
  def methodThichCanReturnNull():String={
    "hello all who work with scala"
  }
  //WAY 1 to verify if the method is falling and returning null
  if (methodThichCanReturnNull() == null){
    //code to defend against null
  }

  //Option = is a collection at most one element, the Some(value) or None
  val anOption = Option(methodThichCanReturnNull())//works with map, flatmap, filter
  //WAY2 to verify if the method is getting null
  val strngProssesing = anOption match {
    case Some(str:String)=>s"I have obtained a valid string: $str"
    case None => "nothing"
  }
  println(strngProssesing)

  def methodWhichThrowException():String=throw new RuntimeException()
  //WAY 3 to verify is a var is gettin an exception or null
  try{
    methodWhichThrowException()
  }catch {
    case e: Exception=>print("Defending from evil exception")
  }
  //WAY 3.2 to verify an exception
  val aTry = Try(methodWhichThrowException())
  //WAY 3.3 to verify if an operation was succesfully or no
  val anotherStringProcessing = aTry match {
    case Success(value)=>s"I have obtained a valid string: $value"
    case Failure(exception)=>"Not a valid string"
  }
  println(anotherStringProcessing)

  /*
  Evaluation something from another thread
   */

  //future is like a collection
  //is composable whit map, faltmap and filter
  val aFuture = Future({//its like future.apply
    println("Starting")
    Thread.sleep(1000)
    println("Value totally computed")
    67
  })
  Thread.sleep(1500)//givin the time to finish the secondary thread (future) and let it to print the last message.

  /*
  IMPLICITS
   */

  //Implicit arguments
  def aMethodWithImplicitArgs(implicit arg:Int) = arg+1
  implicit val dummyImplicit:Int = 46
  println(aMethodWithImplicitArgs)//searches to an implicit value that match with te argument of the func, this case is: aMethodWithImplicitArgs(dummyImplicit)

  //implicits comversions
  implicit class myReachInteger (n:Int){
    def isEven()=n%2==0
  }
  println(23.isEven())//searches for a implicit method from a implicit class that matches with int values with func 'siEven()'
}
