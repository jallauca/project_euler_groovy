// 10001st prime (Problem 7) (https://projecteuler.net/problem=7)

// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

// What is the 10 001st prime number?


// include PrimeGenerator
evaluate(new File("PrimeGenerator.groovy"))
evaluate(new File("Benchmark.groovy"))

// force the compiler to load PrimeGenerator and PrimeNumbe
new PrimeGenerator()

int prime
def duration = Benchmark.run {
    prime = PrimeNumber.n_primes(10001)[-1]
    assert prime == 104743
}

println "tests pass"

println "answer=$prime"
println "Big number benchmark: ${duration} ms"
