name := "Akka-Training"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.3" % "test",
  "org.specs2" %% "specs2-core" % "3.9.1" % "test"
)
