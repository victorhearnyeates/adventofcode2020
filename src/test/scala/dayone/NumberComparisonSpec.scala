package dayone

import scala.io.{BufferedSource, Source}

import dayone.NumberComparison.Chunk
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberComparisonSpec extends AnyFlatSpec with Matchers {

  private val numbersFile: BufferedSource = Source.fromResource("dayone/day-one-numbers")

  "listFromSource" should "load the strings from the file as a List of Ints" in {
    NumberComparison.listFromSource(numbersFile).head shouldBe 1914
  }

  "loop" should "return a Map containing a number -> list if the last element of the list plus the number is greater than 2020" in {
    val chunks = List(List(1,2,3), List(4,5,6), List(7,8,9))
    val number = 2015

    val output = NumberComparison.findPossibleChunks(chunks, number)

    output shouldBe Map(number -> List(4,5,6))
  }

  it should "return a Map containing a number -> list if the last element of the list plus the number is exactly 2020" in {
    val chunks = List(List(1,2,3), List(4,5), List(7,8,9))
    val number = 2015

    val output = NumberComparison.findPossibleChunks(chunks, number)

    output shouldBe Map(number -> List(4,5))
  }

  it should "return and empty acc if none of the numbers add to 2020" in {
    val chunks = List(List(1,2,3), List(4,5), List(7,8,9))
    val number = 2010

    val output = NumberComparison.findPossibleChunks(chunks, number)

    output shouldBe Map.empty[Int, Chunk]
  }

  "compareNumbers" should "return the list of numbers that add to 2020" in {
    val listOfNumbers = NumberComparison.listFromSource(numbersFile)

    NumberComparison.compareNumbers(listOfNumbers) shouldBe List(473, 1547)
  }
}
