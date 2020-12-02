package models

case class Password(firstNum: Int, secondNum: Int, letter: String, passwordBody: String) {
  //doesn't work for mixed case
  def isValid: Boolean =
    passwordBody.sorted.matches(s"(^$letter{$firstNum,$secondNum}[^$letter]+)|([^$letter]+$letter{$firstNum,$secondNum}[^$letter]*)|($letter{$firstNum,$secondNum})")

  def isValid2: Boolean = {
    val arr = passwordBody.toCharArray
    (arr(firstNum - 1) != arr(secondNum - 1)) && (arr(firstNum - 1) == letter.head || arr(secondNum - 1) == letter.head)
  }
}
