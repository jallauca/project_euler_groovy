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
    def prime_factors_recrsv
    prime_factors_recrsv = { long dividend ->
      if ( dividend <= 1 ) return []

      def generator = new PrimeGenerator()
      def prime
      while( (prime = generator.next()) <= n ) {
        if ( dividend % prime == 0 ) { break }
      }
      [prime] + prime_factors_recrsv( dividend.div(prime) as long )
    }

    prime_factors_recrsv(n)
  }
}
