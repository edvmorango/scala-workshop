name := "scala-workshop"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq (
  "org.scalatest" %% "scalatest" % "3.0.0",
).map(_ % Test)