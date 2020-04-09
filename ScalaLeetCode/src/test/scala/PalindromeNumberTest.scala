
import com.leet.palindromenumber.PalindromeNumber
import org.scalatest.FunSuite


class PalindromeNumberTest extends FunSuite {

  test("some true palindromes") {
    val xs = List(101, 202, 2002, 30103)
    for (x <- xs) {
      assert(PalindromeNumber.run(x))
    }
  }

  test("some falsey palindromes") {
    val xs = List(102, 302, 201202, 430103)
    for (x <- xs) {
      assert(!PalindromeNumber.run(x))
    }
  }
}
