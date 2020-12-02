package util

import scala.io.{BufferedSource, Source}

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelpersSpec extends AnyFlatSpec with Matchers {

  private val numbersFile: BufferedSource = Source.fromResource("dayone/day-one-numbers")
  private val passwordFile: BufferedSource = Source.fromResource("daytwo/day-two-passwords")

  "intListFromSource" should "load the strings from the file as a List of Ints" in {
    Helpers.intListFromSource(numbersFile).head shouldBe 1914
  }

  "listFromSource" should "have 1000 strings in" in {
    Helpers.listFromSource(passwordFile).size shouldBe 1000
  }
}
