// Even Fibonacci numbers (Problem 2) (https://projecteuler.net/problem=2)

// Each new term in the Fibonacci sequence is generated by adding the previous
// two terms. By starting with 1 and 2, the first 10 terms will be:

// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

// By considering the terms in the Fibonacci sequence whose values do not
// exceed four million, find the sum of the even-valued terms.


package project.euler.problems

class Problem_02 {
  static void main(String[] args) {
    new Problem_02().run()
  }

  def run() {
    def answer = fibonacci(4000000).findAll { it % 2  == 0 }.sum()
    println "answer=$answer"
  }

  def fibonacci(int max) {
    def fibs = [1,1]

    def iter = [
      next: { fibs = [fibs[1], fibs.sum()] ; return fibs[0] },
      hasNext: { true }
    ] as Iterator

    iter.takeWhile { it <= max }.collect()
  }
}
