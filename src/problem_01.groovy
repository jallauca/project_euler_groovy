// Multiples of 3 and 5 (Problem 1) (https://projecteuler.net/problem=1)

// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

// Find the sum of all the multiples of 3 or 5 below 1000.

package project.euler.problems

class Problem_01 {
  static void main(String[] args) {
    def answer = ( 1..<1000 ).findAll { it % 3 == 0 || it % 5 == 0 }.sum()
    assert answer == 233168

    println "answer=$answer"
  }
}
