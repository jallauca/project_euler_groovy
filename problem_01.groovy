// Multiples of 3 and 5 (Problem 1) (https://projecteuler.net/problem=1)

limit = 1000
answer = ( 1..<limit ).findAll { it % 3 == 0 || it % 5 == 0 }.sum()
assert answer == 233168

println "tests pass"

println "answer=$answer"
