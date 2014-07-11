class Prime {
    def static primes = [1,2,3,5] as Set

    def static List<Integer> up_to(int max) {
        if ( primes.any { it >= max } )
            return primes.takeWhile { it <= max }
        else
            return find_primes(max)
    }

    def static List<Integer> find_primes(int max) {
        for( int n = 3; n < max; n += 2 ) {
            def prime = true
            if ( n % 5 == 0 ) continue
            for ( int j = 2; primes[j] <= Math.sqrt(n); j++ ) {
                if ( n % primes[j] == 0 ) { prime = false; continue }
            }
            if ( prime ) primes << n
        }
        primes.toList()
    }

    def static List<Integer> prime_factors(int n) {
        def primes = find_primes(n*2)
        def factors = [1,2] as SortedSet
        primes.each {
            if ( n % it == 0 ) {
                factors << it
            }
        }
        factors.toList().sort()
    }
}

// http://primes.utm.edu/lists/small/1000.txt
primes_test_string = """
      1
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
    .collect { it.toInteger() }

assert Prime.up_to(1) == [1]
assert Prime.up_to(2) == [1,2]
assert Prime.up_to(3) == [1,2,3]
assert Prime.up_to(5) == [1,2,3,5]
assert expected_primes == Prime.up_to(1015)
assert Prime.prime_factors(100) == [1,2,5]
// println( Prime.prime_factors(600851475143) )

println "tests pass"
