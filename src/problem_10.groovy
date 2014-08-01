// Summation of primes (Problem 10) (https://projecteuler.net/problem=10)

long answer
def duration = Benchmark.run {
  answer = PrimeNumber.primes_up_to(2000000).sum()
}

println "tests pass"

println "Big number benchmark: ${duration} ms"
println "answer=$answer"
