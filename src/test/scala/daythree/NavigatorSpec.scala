package daythree

import scala.io.{BufferedSource, Source}

import models.GeologyRow
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NavigatorSpec extends AnyFlatSpec with Matchers {

  private val passwordFile: BufferedSource = Source.fromResource("daythree/map")

  "geology" should "create a List of Geology rows" in {
    val geology =Navigator.geology(passwordFile)

    geology shouldBe List.empty[GeologyRow]
  }
}
