package daytwo

import scala.io.{BufferedSource, Source}

import models.Password
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import util.Helpers

class PasswordCrackerSpec extends AnyFlatSpec with Matchers {

  private val passwordFile: BufferedSource = Source.fromResource("daytwo/day-two-passwords")
  private val passwords = Helpers.listFromSource(passwordFile)

  "getPassword" should "create a Password model from a string" in {
    val inputString = "1-5 p: pppppp"

    val output = PasswordCracker.getPassword(inputString)
    val expected = Password(1, 5, "p", "pppppp")

    output shouldBe expected
  }

  "getValidPasswords" should "return a list of all the valid passwords" in {
    val validPasswords = PasswordCracker.getValidPasswords(passwords)

    validPasswords.size shouldBe 607
  }

  "getValidPasswords2" should "return a list of all the valid passwords" in {
    val validPasswords = PasswordCracker.getValidPasswords2(passwords)

    validPasswords.size shouldBe 321
  }
}
