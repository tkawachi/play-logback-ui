package com.github.tkawachi.playlogbackui

import ch.qos.logback.classic.{Level, LoggerContext}
import org.slf4j.impl.StaticLoggerBinder
import play.api.mvc.{Action, Controller}

import scala.collection.JavaConverters._

class HomeController extends Controller {
  def index() = Action {
    val context: LoggerContext = getLoggerContext
    val loggers = context.getLoggerList.asScala

    Ok(html.index(loggers))
  }

  private def getLoggerContext = {
    val factory = StaticLoggerBinder.getSingleton.getLoggerFactory
    val context = factory.asInstanceOf[LoggerContext]
    context
  }

  def change() = Action(parse.urlFormEncoded) { request =>
    request.body.get("name").flatMap(_.headOption) match {
      case Some(name) =>
        request.body.get("level").flatMap(_.headOption) match {
          case Some("") =>
            getLoggerContext.getLogger(name).setLevel(null)
            Redirect(routes.HomeController.index())
          case Some(levelName) =>
            val level = Level.toLevel(levelName)
            getLoggerContext.getLogger(name).setLevel(level)
            Redirect(routes.HomeController.index())
          case None =>
            BadRequest("level not found")
        }
      case None =>
        BadRequest("name not found")
    }
  }
}
