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

public class PrimeGenerator implements Iterator<Long> {
    def primes = [2L,3L]
    def position = 0;

    public boolean hasNext() {
        return true;
    }

    public Long next() {
        primes << generate_next()
        return primes[position++]
    }

    private Long generate_next() {
        for( long n = primes[-1] + 2; ; n += 2 ) {
            def prime = true
            for ( int j = 1; primes[j] <= Math.sqrt(n); j++ ) {
                if ( n % primes[j] == 0 ) { prime = false; break }
            }
            if ( prime ) return n
        }
    }

    public void remove(){
        throw new UnsupportedOperationException(
            "Remove is not supported on generators");
   }

    public static void main(String[] args) {
        new PrimeGeneratorTests().run()
    }
}

class PrimeGeneratorTests {
    public static run() {
        def c = 1
        assert new PrimeGenerator().takeWhile { c++ <= 5 }.collect() == [2,3,5,7,11]
        println "tests pass"
    }
}
