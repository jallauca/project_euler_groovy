limit = 1000
divBy3And5 = ( 1..<limit ).findAll { it % 3 == 0 || it % 5 == 0 }
assert divBy3And5.sum() == 233168
println "tests pass"
