package project.euler.problems

import org.junit.*

class Problem_04Test {
  @Test
  void is_palindrome() {
    assert new Problem_04().is_palindrome(1)
    assert !new Problem_04().is_palindrome(10)
    assert new Problem_04().is_palindrome(101)
    assert !new Problem_04().is_palindrome(5010)
    assert new Problem_04().is_palindrome(50105)
  }

  @Test
  void find_each_palindrome() {
    def two_digit_numbers = new Problem_04().n_digit_numbers(2)
    def three_digit_numbers = new Problem_04().n_digit_numbers(3)
    assert new Problem_04().find_each_palindrome_of_products( two_digit_numbers ).max() == 9009
    assert new Problem_04().find_each_palindrome_of_products( three_digit_numbers ).max() == 906609
  }
}
