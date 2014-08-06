// Summation of primes (Problem 10) (https://projecteuler.net/problem=10)

package project.euler.problems

class Problem_10 {
  static void main(String[] args) {
    new Problem_10().run()
  }

  def run() {
    long answer = 0
    def duration = Benchmark.run {
      def generator = new PrimeGenerator()
      def prime
      while ( (prime = generator.next()) <= 2000000 )
        answer += prime
    }

    print "answer=$answer"
    println " Big number benchmark: ${duration} ms"
  }
}
