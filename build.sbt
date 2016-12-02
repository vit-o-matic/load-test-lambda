name := "load-test-lambda"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.amazonaws" % "aws-lambda-java-events" % "1.1.0",
  "com.typesafe" % "config" % "1.3.1"
)

assemblyJarName in assembly := {
  name.value + "-" + version.value + ".jar"
}

retrieveManaged := true

enablePlugins(AwsFunPlugin)

awsLambdaHandlers := Seq(
  "EnqueueLoadHitResult"  -> "vitomatic.LoadHitResultQueue::enqueue",
  "EchoFunction" -> "vitomatic.LoadHitResultQueue::echo"
)

awsS3Bucket := Some("lambda-scala")

awsLambdaMemorySize := Some(192)

awsLambdaTimeout := Some(30)


fork in run := true
