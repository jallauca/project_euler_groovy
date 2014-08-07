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
  Problem_12(int divisorCount) {
    this.divisorCount = divisorCount
    IterableMonkeyPatch.apply()
  }

  int divisorCount

  static void main(String[] args) {
    def answer = new Problem_12(500).run()
    assert answer==76576500
    println("answer=$answer")
  }

  def run() {
    if (divisorCount < 1) return 0
    if (divisorCount == 1) return 1

    def generator = new TriangleNumberGenerator()
    generator.next() // Skip #1

    def answer
    while ( !answer ) {
      def triangleNumber = generator.next()
      def prime_factors = PrimeNumber.prime_factors(triangleNumber)

      def combinationIsUnique = factorsCombinationIsUnique(prime_factors)
      if ( combinationIsUnique ) {
        def factors = PrimeNumber.factors(triangleNumber)
        if ( factors.size() >= divisorCount ) { answer = triangleNumber }
      }
    }
    answer
  }

  def possible_combinations_map = [:]
  int possibleFactors(int n) {
    def possible_combinations = possible_combinations_map[n]
    if ( !possible_combinations ) {
      possible_combinations = (1..n).inject(0) { acc, k ->
          acc + factorial(n).div(factorial(k) * factorial(n - k))
        }
      possible_combinations_map[n] = possible_combinations
    }
    return possible_combinations
  }

  def uniqueCounts = [""] as Set
  boolean factorsCombinationIsUnique(List<Long> prime_factors) {
    def counts = prime_factors.countBy { it }.collect { k, v -> v }.sort().toString()
    def isUnique = !(counts in uniqueCounts)
    if (isUnique) { uniqueCounts << counts }
    isUnique
  }

  long factorial(int n) {
    if ( n == 0 ) return 1
    (1..n).inject(1) { product, value -> product * value }
  }

  long product_of_each(List<Integer> ns) {
    ns.inject(1) { seed, n -> (seed * n) as long }
  }
}
