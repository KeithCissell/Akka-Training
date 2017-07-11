package akkatutorial

import akka.actor._

object Supervising {

  implicit val system = ActorSystem()

  class SupervisingActor extends Actor {
    val child = context.actorOf(Props[SupervisedActor], "supervised-actor")

    override def receive: Receive = {
      case "failChild" => child ! "fail"
    }
  }

  class SupervisedActor extends Actor {
    override def preStart(): Unit = println("supervised actor started")
    override def postStop(): Unit = println("supervised actor stopped")

    override def receive: Receive = {
      case "fail" =>
        println("supervised actor fails now")
        throw new Exception("I failed!")
    }
  }

  def main(args: Array[String]) {
    val supervisingActor = system.actorOf(Props[SupervisingActor], "supervising-actor")
    supervisingActor ! "failChild"
  }
}
