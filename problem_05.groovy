// Smallest multiple (Problem 5)

// 2520 is the smallest number that can be divided by each of the numbers from
// 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the
// numbers from 1 to 20?

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
