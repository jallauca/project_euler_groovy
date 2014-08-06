// Highly divisible triangular number (Problem 12) (https://projecteuler.net/problem=12)

// The sequence of triangle numbers is generated by adding the natural numbers.
// So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
// ten terms would be:

// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

// Let us list the factors of the first seven triangle numbers:

//  1: 1
//  3: 1,3
//  6: 1,2,3,6
// 10: 1,2,5,10
// 15: 1,3,5,15
// 21: 1,3,7,21
// 28: 1,2,4,7,14,28
// We can see that 28 is the first triangle number to have over five divisors.

// What is the value of the first triangle number to have over five hundred divisors?

package project.euler.problems

class Problem_12 {
  Problem_12() {
    IterableMonkeyPatch.apply()
  }

  static void main(String[] args) {
    def answer = new Problem_12().run()

    assert answer==76576500
    println("\nanswer=$answer")
  }

  def run() {
    def generator = new TriangleNumberGenerator()
    def answer
    def divisorCount = 500

    while ( !answer ) {
      def triangleNumber = generator.next()
      def prime_factors = factors(triangleNumber)

      def possible_factors = possibleFactors( prime_factors.size() )
      if ( possible_factors >= divisorCount ) {
        def factors = allFactorsFromPrimeFactors(prime_factors)
        if ( factors.size() >= divisorCount ) { answer = triangleNumber }
      }
    }

    answer
  }

  def static factors(long n) {
    if ( n < 1 ) return []
    if ( n == 1 ) return [1]
    PrimeNumber.prime_factors(n)
  }

  def possible_combinations_map = [:]
  def int possibleFactors(n) {
    def possible_combinations = possible_combinations_map[n]
    if ( !possible_combinations ) {
      possible_combinations =
        (1..n).collect { k ->
          factorial(n).div(factorial(k) * factorial(n - k))
        }.sum()
      possible_combinations_map[n] = possible_combinations
    }
    return possible_combinations
  }

  def factorial(int n) {
    if ( n == 0 ) return 1
    (1..n).inject(1) { product, value -> product * value }
  }

  def product_of_each = { List<Integer> ns ->
    ns.inject(1) { seed, n -> (seed * n) as long }
  }

  def totalTime = 0, totalTime2 = 0
  def allFactorsFromPrimeFactors(List<Long> prime_factors) {
    def factors_combinations, factors
    totalTime += Benchmark.run {
      factors_combinations = (1..prime_factors.size()).collect { k ->
        prime_factors.kCombinations(k)
      }
    }
    totalTime2 += Benchmark.run {
      factors = factors_combinations.collect {
        klist -> klist.collect { n_factors -> product_of_each(n_factors) }
      }.flatten() as Set
    }
    println("${totalTime} ms, ${totalTime2} ms, ${totalTime + totalTime2}")
    factors
  }
}
