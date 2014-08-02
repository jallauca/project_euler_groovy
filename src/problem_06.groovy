// Sum square difference (Problem 6) (https://projecteuler.net/problem=6)

// The sum of the squares of the first ten natural numbers is,

// 1^2 + 2^2 + ... + 10^2 = 385

// The square of the sum of the first ten natural numbers is,

// (1 + 2 + ... + 10)^2 = 552 = 3025

// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

package project.euler.problems

class Problem_06 {
  def sum_of_squares(IntRange range) {
    range.collect { it.power(2) }.sum()
  }

  def square_of_sums(IntRange range) {
    range.sum().power(2)
  }

  def sum_square_difference(IntRange range) {
    square_of_sums( range ) - sum_of_squares( range )
  }

  static void main(String[] args) {
    new Problem_06().run()
  }

  def run() {
    assert sum_of_squares( (1..10) ) == 385
    assert square_of_sums( (1..10 ) ) == 3025
    assert sum_square_difference( (1..10) ) == 2640
    assert sum_square_difference( (1..100) ) == 25164150

    println "tests pass"

    def answer = sum_square_difference( (1..100) )
    println "answer=$answer"
  }
}
