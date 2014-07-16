// Summation of primes (Problem 10) (https://projecteuler.net/problem=10)

// include PrimeGenerator
evaluate(new File("PrimeGenerator.groovy"))

// force the compiler to load PrimeGenerator and PrimeNumbe
new PrimeGenerator()

long answer
def duration = Benchmark.run {
    answer = PrimeNumber.primes_up_to(2000000).sum()
}

println "tests pass"

println "Big number benchmark: ${duration} ms"
println "answer=$answer"
