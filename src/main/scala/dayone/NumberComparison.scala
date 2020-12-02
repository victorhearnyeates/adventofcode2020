package dayone

import scala.annotation.tailrec
import scala.io.BufferedSource

object NumberComparison {

  type Chunk = List[Int]

  def listFromSource(source: BufferedSource): List[Int] = source.getLines().toList.map(_.toInt)

  def compareTwoNumbers(list: List[Int]): List[Int] = {
    val sorted = list.sorted
    val chunked = sorted.sliding(10,10).toList
    val shortList = sorted.flatMap(number => findPossibleChunks(chunked, number))
    shortList.withFilter {
      case (number, chunk) => chunk.map(_ + number).contains(2020)
    }.map(_._1)
  }

  def compareThreeNumbers(list: List[Int]): Set[Int] = {
    val sorted = list.sorted
    val largestPossibleSmallNumber = 2020 - sorted.take(2).sum
    val filtered = list.filter(_ <= largestPossibleSmallNumber)
    //filtered is only 39, so don't mind brute forcing it
    val number = (for {
      number1 <- filtered
      number2 <- filtered
      number3 <- filtered
      if number1 + number2 + number3 == 2020
    } yield number1 * number2 * number3).toSet
    number
  }

  @tailrec
  def findPossibleChunks(list: List[Chunk], number: Int, acc: Map[Int, Chunk] = Map.empty[Int, Chunk]): Map[Int, Chunk] = list match {
    case Nil => acc
    case h :: t =>
      if (h.last + number >= 2020) findPossibleChunks(t, number, Map(number -> h) ++ acc)
      else findPossibleChunks(t, number, acc)
  }
}
