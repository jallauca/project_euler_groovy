// Smallest multiple (Problem 5) (https://projecteuler.net/problem=5)

// 2520 is the smallest number that can be divided by each of the numbers from
// 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the
// numbers from 1 to 20?

// Solution Tips:
// From http://en.wikipedia.org/wiki/Prime_number:

//   Fundamental theorem of arithmetic
//   Main article: Fundamental theorem of arithmetic
//   The fundamental theorem of arithmetic states that every integer larger than
//   1 can be written as a product of one or more primes in a way that is unique
//   except for the order of the prime factors.
//   For example:

//   23244	= 2 · 2 · 3 · 13 · 149
//          = 2^2   · 3 · 13 · 149


// Given that, my deduction:

// The prime factors of the 10 first numbers
//   10 = 5 * 2
//    9 = 3 * 3
//    8 = 2 * 2 * 2
//    7 = 7
//    6 = 3 * 2
//    5 = 5
//    4 = 2 * 2
//    3 = 3
//    2 = 2
//    1 = N/A

// The smallest multiple for a list of numbers is the maximum count of primes
// found for each number. For the example above, we have the following
// maps of counts for each prime:
//   [ 7:1, 5:1, 3:2, 2:3 ]
// 7 and 5 appear only 1 time each, 3 appears a maximum of 2 times, 2 appears a
// maximum of 3 times

// Thus,
//   smallest multiple = 7 * 5 * 3*3 * 2*2*2 = 2520

package project.euler.problems

class Problem_05 {
  def primes_by_higher_count_of_factors(IntRange prime_range) {
    prime_range
    .collect { PrimeNumber.prime_factors(it).countBy { it } }
    .inject([ : ]) { prime_by_count, groups ->
      groups.each { prime, count ->
        prime_by_count[prime] = [prime_by_count[prime], count].max()
      }
      prime_by_count
    }
  }

  def smallest_multiple(IntRange prime_range) {
    primes_by_higher_count_of_factors( prime_range )
    .inject( 1 ) { seed, prime, prime_count ->
      seed * prime.power(prime_count)
    }
  }

  static void main(String[] args) {
    new Problem_05().run()
  }

  def run() {
    assert smallest_multiple( (1..10) ) == 2520
    assert smallest_multiple( (1..20) ) == 232792560

    println "tests pass"

    def answer = smallest_multiple( (1..20) )
    println "answer=$answer"
  }
}
