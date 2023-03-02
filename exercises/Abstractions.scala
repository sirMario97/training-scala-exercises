object ContesxtualAbstractions {
/*
things that made scala very expresive
1- context parameters/atguments
 */

    val list = List(2,1,3,4)
    val orderedList = list.sorted//an default ordering function, without editingthe contextual argument; uses ascending ordenation

    //Ordering function, this is used for ordering function, whe you change it, it also do for all methods that uses it.
    given descOrd: Ordering[Int] = Ordering.fromLessThan(_ > _)//(a,b)=> a>b

    //analogous to an implicit val
    trait Combinator[A]{
        def combine(x:A,y:A):A
    }

    def combineAll[A](list:List[A])(using combinator: Combinator[A]):A=list.reduce((a,b)=>combinator.combine(a,b))
    given intCombinator: Combinator[Int] = new Combinator[Int]{
        override def combine(x:Int, y:Int)=x+y
    }
    val theSum=combineAll(list)

    /*
    EXTENSION METHODS
    */
    case class Person(name:String){
        def greet():String=s"Hi, im $name and i love scala"
    }
    extension (str: String){
        def greet():String=new Person(str).greet()
    }

    val danielsGreet="This person says".greet()

    //using extensions to create a better way to combain a list
    extension [A](list:List[A])
        def combineAllVals(using combinator:Combinator[A]):A=
            list.reduce(combinator.combine)
    
    val theSum_v2=list.combineAllVals

    def main(args: Array[String]): Unit = {
        println(orderedList)
        println(theSum)
        println(danielsGreet)
        println(theSum_v2)
    }
}