package daythree

import scala.io.BufferedSource

import models.GeologyRow

object Navigator {

  def geology(buf: BufferedSource): List[GeologyRow] = buf.getLines().toList.map(_.split("")).map(GeologyRow)
}
