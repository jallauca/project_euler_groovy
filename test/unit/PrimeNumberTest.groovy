package project.euler.problems

import org.junit.*

class PrimeNumberTest {
  @Test
  void find_prime_factors() {
    assert PrimeNumber.find_prime_factors(100) == [2,5]
  }

  @Test
  void primes_up_to() {
    assert PrimeNumber.primes_up_to(1) == []
    assert PrimeNumber.primes_up_to(2) == [2]
    assert PrimeNumber.primes_up_to(3) == [2,3]
    assert PrimeNumber.primes_up_to(5) == [2,3,5]
    assert PrimeNumber.primes_up_to(25) == [2,3,5,7,11,13,17,19,23]
  }

  @Test
  void n_primes() {
    assert PrimeNumber.n_primes(-1) == []
    assert PrimeNumber.n_primes(0) == []
    assert PrimeNumber.n_primes(1) == [2]
    assert PrimeNumber.n_primes(10) == [2,3,5,7,11,13,17,19,23,29]
  }

  @Test
  void prime_factors() {
    assert PrimeNumber.prime_factors(1)  == []
    assert PrimeNumber.prime_factors(2)  == [2]
    assert PrimeNumber.prime_factors(3)  == [3]
    assert PrimeNumber.prime_factors(4)  == [2,2]
    assert PrimeNumber.prime_factors(5)  == [5]
    assert PrimeNumber.prime_factors(6)  == [2,3]
    assert PrimeNumber.prime_factors(7)  == [7]
    assert PrimeNumber.prime_factors(8)  == [2,2,2]
    assert PrimeNumber.prime_factors(9)  == [3,3]
    assert PrimeNumber.prime_factors(10) == [2,5]
    assert PrimeNumber.prime_factors(20) == [2,2,5]
  }

  @Test
  void prime_upto_1015() {
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
  }

  @Test
  void factors() {
    assert PrimeNumber.factors(-1).toList() == []
    assert PrimeNumber.factors(0).toList()  == []
    assert PrimeNumber.factors(1).toList().sort()  == [1]
    assert PrimeNumber.factors(2).toList().sort()  == [1,2]
    assert PrimeNumber.factors(3).toList().sort()  == [1,3]
    assert PrimeNumber.factors(4).toList().sort()  == [1,2,4]
    assert PrimeNumber.factors(6).toList().sort()  == [1,2,3,6]
    assert PrimeNumber.factors(10).toList().sort() == [1,2,5,10]
    assert PrimeNumber.factors(15).toList().sort() == [1,3,5,15]
    assert PrimeNumber.factors(21).toList().sort() == [1,3,7,21]
    assert PrimeNumber.factors(28).toList().sort() == [1,2,4,7,14,28]
  }
}
