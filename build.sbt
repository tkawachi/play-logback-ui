val commonSettings = Seq(
  organization := "com.github.tkawachi",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/tkawachi/play-logback-ui/"),
      "scm:git:github.com:tkawachi/play-logback-ui.git"
    )),
  homepage := Some(url("https://github.com/tkawachi/play-logback-ui/")),
  developers := List(
    Developer("tkawachi",
              "Takashi Kawachi",
              "tkawachi@gmail.com",
              url("https://github.com/tkawachi"))),
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint"
  )
)

lazy val root = project
  .in(file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "play-logback-ui-root",
    description := "Play logback UI root"
  )
  .aggregate(core, sample)

lazy val core = project
  .in(file("core"))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings ++ Seq(
      name := "play-logback-ui",
      description := "Play logback UI",
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
      )
    ): _*
  )

lazy val sample = project
  .in(file("sample"))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings ++ Seq(
      name := "play-logback-ui-sample",
      description := "Play logback UI sample"
    )
  )
  .dependsOn(core)
