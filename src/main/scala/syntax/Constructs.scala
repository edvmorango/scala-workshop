package syntax

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
// Option
// Either
// Try
// Future


object Main3 extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

//  val promise = Future {
//    println("Block")
//    Thread.sleep(5000)
//    println("After block")
//  }
//
//  val promise2 = Future {
//    println("Block 2 ")
//    Thread.sleep(1000)
//    println("After block - 2")
//  }


  private def requestParser(value: String) : Future[Int] = Future {
    Thread.sleep(1000)
    println(s"${Thread.currentThread.getName()} - Parsear a requisiçao")
    value.toInt
  }


  private def businessRuleService(value: Int): Future[Int] = Future {
    Thread.sleep(1000)
    println(s"${Thread.currentThread.getName()} - Começar as regras de negocio")
    value
  }

  private def repositoryAction(value: Int): Future[Unit] = Future {
    Thread.sleep(1000)
    println(s"${Thread.currentThread.getName()} - Salvar informaçao")
  }

  private def responseParser(unit: Unit): Future[Unit] = Future {
    println(s"${Thread.currentThread.getName()} - Responder a requisiçao")
  }

  def composition()  = {
  requestParser("aaaaa").fallbackTo(Future{-1})
    .flatMap(businessRuleService)
    .flatMap(repositoryAction)
    .flatMap(responseParser)
  }


  def composition2()  = {
    requestParser("aaaaa")
      .flatMap(businessRuleService)
      .flatMap(repositoryAction)
      .flatMap(responseParser)
      .onComplete { res =>  res match {
        case Success(s) => println("Success ")
        case Failure(e) =>  println(s"Failture: ${e.getMessage}")
      }}
  }

  composition()
  composition2()


  Thread.sleep(10000)


}



object Main4 extends App {

  def convertStringToInt(value: String): Option[Int] = {
    if(value.map(_.isDigit).fold(true)(_ && _))
      Some(value.toInt)
    else
      None
  }

  convert("1")
  convert("2")
  convert("AAAA")





}

