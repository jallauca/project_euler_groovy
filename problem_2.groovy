def nextFib(List<Integer> seed) {
    seed[-1] + seed[-2]
}

def fibonnacci(int max) {
    if ( max <= 0 ) { return [] }
    if ( max == 1 ) { return [1] }
    if ( max == 2 ) { return [1,2] }

    series = [1,2]
    int nextInSeries

    while( (nextInSeries = nextFib(series[-2..-1])) <= max )
        series << nextInSeries

    series
}

assert fibonnacci(-4) == []
assert fibonnacci(0) == []
assert fibonnacci(1) == [1]
assert fibonnacci(2) == [1,2]
assert fibonnacci(4000000).findAll { it % 2  == 0 }.sum() == 4613732
println "tests pass"
