package akkatutorial

import akka.actor._
import scala.concurrent.duration._


object PrintActor {

  implicit val system = ActorSystem()

  class PrintMyActorRefActor extends Actor {
    override def receive: Receive = {
      case "printit" =>
        val secondRef = context.actorOf(Props.empty, "second-actor")
        println(s"Second: $secondRef")
    }
  }

  def main(args: Array[String]) {
    val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")
    println(s"First : $firstRef")
    firstRef ! "printit"
  }

}
