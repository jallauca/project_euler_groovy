public class PrimeNumber {
    def static primes_up_to(long max) {
        new PrimeGenerator().takeWhile { it <= max }.collect()
    }

    def static n_primes(int n) {
        def c = 1
        new PrimeGenerator().takeWhile { c++ <= n }.collect()
    }

    def static List<Long> find_prime_factors(long n) {
        def primes = primes_up_to( Math.sqrt(n).toLong() )
        primes.findAll { n % it == 0 }.toList()
    }

    public static void main(String[] args) {
        new PrimeNumberTests().run()
    }
}

class PrimeNumberTests {
    public static run() {
        assert PrimeNumber.find_prime_factors(100) == [2,5]
        assert PrimeNumber.primes_up_to(2) == [2]
        assert PrimeNumber.primes_up_to(3) == [2,3]
        assert PrimeNumber.primes_up_to(5) == [2,3,5]
        assert PrimeNumber.n_primes(10) == [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

        // http://primes.utm.edu/lists/small/1000.txt
        def primes_test_string = """
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

        def expected_primes =
            primes_test_string
            .replaceAll(/\s\s*/, ' ').stripIndent().split(' ')
            .collect { it.toLong() }

        assert PrimeNumber.primes_up_to(1015) == expected_primes

        println "tests pass"
    }
}
