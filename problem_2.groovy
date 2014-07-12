def fibonacci(int max) {
    def fibs = [1,1]

    iter = [
       next: { fibs = [fibs[1], fibs.sum()] ; return fibs[0] },
       hasNext: { true }
   ] as Iterator

    iter.takeWhile { it <= max }.collect()
}

assert fibonacci(-4) == []
assert fibonacci(0) == []
assert fibonacci(1) == [1]
assert fibonacci(2) == [1,2]
assert fibonacci(4000000).findAll { it % 2  == 0 }.sum() == 4613732

println "tests pass"
