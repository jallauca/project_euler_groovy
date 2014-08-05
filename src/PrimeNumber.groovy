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

    def generator = new PrimeGenerator()
    def factors = [1, n] as Set
    def primeDivisorTooLarge = false

    while ( !primeDivisorTooLarge ) {
      def prime = generator.next()
      def divisorMultiple = 1
      while ( true ) {
        def divisor = prime * divisorMultiple
        def quotient = n.div(divisor)
        if ( quotient < 2 ) {
          if ( divisorMultiple == 1 ) { primeDivisorTooLarge = true }
          break
        }
        if ( n % divisor == 0 ) factors.add(divisor)
        divisorMultiple += 1
      }
    }

    factors.toList().sort()
  }
}
