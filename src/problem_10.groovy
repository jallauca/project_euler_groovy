// Summation of primes (Problem 10) (https://projecteuler.net/problem=10)


package project.euler.problems

class Problem_10 {
  static void main(String[] args) {
    new Problem_10().run()
  }

  def run() {
    long answer
    def duration = Benchmark.run {
      answer = PrimeNumber.primes_up_to(2000000).sum()
    }

    println "tests pass"

    println "Big number benchmark: ${duration} ms"
    println "answer=$answer"
  }
}
