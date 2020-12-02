package daytwo

import scala.util.matching.Regex

import models.Password

object PasswordCracker {

  //sample password 1-5 p: pppppp
  private val passwordRegex: Regex = "(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)".r

  def getPassword(password: String): Password = password match {
    case passwordRegex(num1, num2, letter, body) => Password(num1.toInt, num2.toInt, letter, body)
  }

  def getValidPasswords(passwords: List[String]): List[Password] = passwords.map(getPassword).filter(_.isValid)

  def getValidPasswords2(passwords: List[String]): List[Password] = passwords.map(getPassword).filter(_.isValid2)
}
