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

class PrimeGenerator implements Iterator<Long> {
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
}

def benchmark = { closure ->
  start = System.currentTimeMillis()
  closure.call()
  now = System.currentTimeMillis()
  now - start
}

def primes_up_to(long max) {
    new PrimeGenerator().takeWhile { it <= max }.collect()
}

def List<Long> find_prime_factors(long n) {
    def primes = primes_up_to( Math.sqrt(n).toLong() )
    primes.findAll { n % it == 0 }.toList()
}

assert find_prime_factors(100) == [2,5]
assert primes_up_to(2) == [2]
assert primes_up_to(3) == [2,3]
assert primes_up_to(5) == [2,3,5]

duration = benchmark {
    assert find_prime_factors(600851475143).max() == 6857
}
println "Big number benchmark: ${duration} ms"

// http://primes.utm.edu/lists/small/1000.txt
primes_test_string = """
      2      3      5      7     11     13     17     19     23     29
     31     37     41     43     47     53     59     61     67     71
     73     79     83     89     97    101    103    107    109    113
    127    131    137    139    149    151    157    163    167    173
    179    181    191    193    197    199    211    223    227    229
    233    239    241    251    257    263    269    271    277    281
    283    293    307    311    313    317    331    337    347    349
    353    359    367    373    379    383    389    397    401    409
    419    421    431    433    439    443    449    457    461    463
    467    479    487    491    499    503    509    521    523    541
    547    557    563    569    571    577    587    593    599    601
    607    613    617    619    631    641    643    647    653    659
    661    673    677    683    691    701    709    719    727    733
    739    743    751    757    761    769    773    787    797    809
    811    821    823    827    829    839    853    857    859    863
    877    881    883    887    907    911    919    929    937    941
    947    953    967    971    977    983    991    997   1009   1013"""

expected_primes =
    primes_test_string
    .replaceAll(/\s\s*/, ' ').stripIndent().split(' ')
    .collect { it.toLong() }
assert primes_up_to(1015) == expected_primes

println "tests pass"
