package akkatutorial

import akka.actor._
import scala.concurrent.duration._


object PrintActor {

  class PrintMyActorRefActor extends Actor {
    override def receive: Receive = {
      case "printit" =>
        val secondRef = context.actorOf(Props.empty, "second-actor")
        println(s"Second: $secondRef")
    }
  }

  def main(args: Array[String]) {
    val system = ActorSystem("PrintActor")

    val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")
    println(s"First : $firstRef")
    firstRef ! "printit"
  }

}
