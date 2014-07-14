// Smallest multiple (Problem 5)

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

// The prime factors of the 10 first numbers
//   10 = 5 · 2
//    9 = 3 · 3
//    8 = 2 · 2 · 2
//    7 = 7
//    6 = 3 · 2
//    5 = 5
//    4 = 2 · 2
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


// include PrimeGenerator
evaluate(new File("PrimeGenerator.groovy"))

// force the compiler to load PrimeGenerator and PrimeNumbe
new PrimeGenerator()

def prime_factors(int n) {
    def primes = PrimeNumber.primes_up_to(n)
    all_prime_factors(n, primes)
}

def all_prime_factors(int n, List<Integer> primes) {
    if ( n <= 1 ) return []

    prime = primes.find { n % it == 0 }
    [prime] + all_prime_factors( prime ? n.div(prime).toInteger() : 1, primes )
}

assert prime_factors(1)  == []
assert prime_factors(2)  == [2]
assert prime_factors(3)  == [3]
assert prime_factors(4)  == [2,2]
assert prime_factors(5)  == [5]
assert prime_factors(6)  == [2,3]
assert prime_factors(7)  == [7]
assert prime_factors(8)  == [2,2,2]
assert prime_factors(9)  == [3,3]
assert prime_factors(10) == [2,5]
assert prime_factors(20) == [2,2,5]

def primes_by_higher_count_of_factors(prime_range) {
    prime_range
    .collect { prime_factors(it).countBy { it } }
    .inject([ : ]) { prime_by_count, groups ->
        groups.each { prime, prime_count ->
            new_count = prime_count
            old_count = prime_by_count[prime] ?: 0
            if ( new_count > old_count ) prime_by_count[prime] = new_count
        }
        prime_by_count
    }
}

def smallest_multiple(prime_range) {
    primes_by_higher_count_of_factors( prime_range )
    .inject( 1 ) { seed, prime, prime_count ->
        seed * prime.power(prime_count)
    }
}

assert smallest_multiple( (1..10) ) == 2520
assert smallest_multiple( (1..20) ) == 232792560

println "tests pass"
