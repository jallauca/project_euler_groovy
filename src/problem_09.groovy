// Special Pythagorean triplet (Problem 9) (https://projecteuler.net/problem=09)
// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

// a^2 + b^2 = c^2
// For example, 32 + 42 = 9 + 16 = 25 = 52.

// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

// Solution tips:
// Speed the process by the fact that by enumerating a = (1..1000),
// b and c are two complimentary numbers such that:
//    b + c = 1000 - a

def pythagorean_triplet(int a, int b, int c) {
  a.power(2) + b.power(2) == c.power(2)
}

assert pythagorean_triplet(3, 4, 5) == true

def sum = 1000
def triplets
def duration = Benchmark.run {
  triplets = 
  (1..sum).findResult { a ->
    def half = (sum - a).div(2) as int
    (a+1..a+1+half).findResult { b ->
      def c = sum - a - b
      if ( c > 0 && pythagorean_triplet(a, b, c) ) return [a,b,c]
    }
  }
}

def answer = triplets.inject { p, n -> p * n }
assert answer == 31875000
println "tests pass"

println "triplets=${triplets}"
println "benchmark: ${duration} ms"
println "answer=$answer"
