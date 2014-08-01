// Largest prime factor (Problem 3) (https://projecteuler.net/problem=3)

// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?

// (http://en.wikipedia.org/wiki/Prime_number)
// The most basic method of checking the primality of a given integer n is called
// trial division. This routine consists of dividing n by each integer m that is
// greater than 1 and less than or equal to the square root of n. If the result
// of any of these divisions is an integer, then n is not a prime, otherwise it
// is a prime. Indeed, if n=a b is composite (with a and b ≠ 1) then one of the
// factors a or b is necessarily at most \sqrt{n}. For example, for  n = 37 , the
// trial divisions are by m = 2, 3, 4, 5, and 6. None of these numbers divides
// 37, so 37 is prime. This routine can be implemented more efficiently if a
// complete list of primes up to \sqrt{n} is known—then trial divisions need to
// be checked only for those m that are prime. For example, to check the primality
// of 37, only three divisions are necessary (m = 2, 3, and 5), given that 4 and
// 6 are composite.

int answer
def duration = Benchmark.run {
  answer = PrimeNumber.find_prime_factors(600851475143).max()
  assert answer == 6857
}
println "tests pass"

println "answer=$answer"
println "Big number benchmark: ${duration} ms"
