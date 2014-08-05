package project.euler.problems

class PrimeNumber {
  def static primes_up_to(long max) {
    new PrimeGenerator().takeWhile { it <= max }.collect()
  }

  def static n_primes(int n) {
    new PrimeGenerator().take(n).collect()
  }

  def static List<Long> find_prime_factors(long n) {
    def primes = primes_up_to( Math.sqrt(n) as long )
    primes.findAll { n % it == 0 }
  }

  def static prime_factors(long n) {
    def primes = PrimeNumber.primes_up_to(n)

    def prime_factors_recrsv
    prime_factors_recrsv = { long dividend ->
      if ( dividend <= 1 ) return []

      def prime = primes.find { prime -> dividend % prime == 0 }
      [prime] + prime_factors_recrsv( dividend.div(prime) as long )
    }

    prime_factors_recrsv(n)
  }

  def static factors(long n) {
    if ( n < 1 ) return []
    if ( n == 1 ) return [1]
    PrimeNumber.prime_factors(n)
  }
}
