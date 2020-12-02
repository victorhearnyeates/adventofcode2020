package models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PasswordSpec extends AnyFlatSpec with Matchers {

  "isValid" should "return true if the password body is a valid password and letter is a" in {
    val input = Password(1,4,"a", "tomrsdfcnsajnanc")

    assert(input.isValid)
  }

  it should "return false if the password body is not a valid password" in {
    val input = Password(1,4,"a", "taomarsdfcnsajananc")

    assert(!input.isValid)
  }

  it should "return false if the password body is a valid password and letter is b" in {
    val input = Password(1,4,"b", "taomarsdfcnsbajabnabnc")

    assert(input.isValid)
  }

  it should "return valid for 5-16 b: bbbbhbbbbpbxbbbcb" in {
    val input = Password(5, 16, "b", "bbbbhbbbbpbxbbbcb")

    assert(input.isValid)
  }

  it should "return valid for 2-3 w: wwmw" in {
    val input = Password(2, 3, "w", "wwmw")

    assert(input.isValid)
  }

  "isValid2" should "return true for 2-3 w: wwmw" in {
    val input = Password(2, 3, "w", "wwmw")

    assert(input.isValid2)
  }

  it should "return false for 2-3 w: wwmmw" in {
    val input = Password(2, 3, "w", "wwwmmw")

    assert(!input.isValid2)
  }

  it should "return false for 2-3 w: wmmw" in {
    val input = Password(2, 3, "w", "wmmw")

    assert(!input.isValid2)
  }
}
