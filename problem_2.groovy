class FibonacciGenerator implements Iterator<Integer> {
    def fibs = [1,1]

    def boolean hasNext() {
        true
    }

    def Integer next() {
        fibs = [fibs[1], fibs.sum()]
        return fibs[0]
    }

    public void remove(){
        throw new UnsupportedOperationException(
            "Remove is not supported on generators");
   }
}

def fibonacci(int max) {
    new FibonacciGenerator().takeWhile { it <= max }.collect()
}

assert fibonacci(-4) == []
assert fibonacci(0) == []
assert fibonacci(1) == [1]
assert fibonacci(2) == [1,2]
assert fibonacci(4000000).findAll { it % 2  == 0 }.sum() == 4613732

println "tests pass"
