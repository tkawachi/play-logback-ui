val commonSettings = Seq(
  organization := "com.github.tkawachi",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scmInfo := Some(ScmInfo(
    url("https://github.com/tkawachi/play-logback-ui/"),
    "scm:git:github.com:tkawachi/play-logback-ui.git"
  )),

  scalaVersion := "2.11.8",
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint"
  )
)

lazy val root = project.in(file("."))
  .settings(commonSettings :_*)
  .settings(
    name := "play-logback-ui",
    description := "Play logback UI",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    )
  )
