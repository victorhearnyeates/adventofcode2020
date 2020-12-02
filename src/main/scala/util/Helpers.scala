package util

import scala.io.BufferedSource

object Helpers {
  def intListFromSource(source: BufferedSource): List[Int] = source.getLines().toList.map(_.toInt)
  def listFromSource(source: BufferedSource): List[String] = source.getLines().toList
}
