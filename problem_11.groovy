evaluate(new File("IterableMonkeyPatch.groovy"))

def number_grid(n) { (0..<n.power(2)) }

def grid_consecutive_vertical = { int n, int cons = 3 ->
    number_grid(n)
    .findAll { it -> it + n*(cons-1) < n.power(2) }
    .collect { (it..it + n*(cons-1)).step(n) }
}

def grid_consecutive_incline_right = { int n, int cons = 3 ->
    grid_consecutive_vertical(n, cons)
    .findAll { x -> x[0] % n < n - cons + 1 }
    .collect { [it, (0..100)].transpose().collect { it.sum() } }
}

def grid_consecutive_incline_left = { int n, cons = 3 ->
    grid_consecutive_vertical(n, cons)
    .findAll { x -> x[0] % n > cons - 2 }
    .collect { [it, (0..-100)].transpose().collect { it.sum() } }
}

// println grid_consecutive_incline_right(10,4)
// println grid_consecutive_incline_left(10,4)
// println grid_consecutive_vertical(10,4)

assert grid_consecutive_vertical(3) == [[0, 3, 6], [1, 4, 7], [2, 5, 8]]
assert grid_consecutive_incline_right(3) == [[0, 4, 8]]
assert grid_consecutive_incline_left(3) == [[2, 4, 6]]

assert grid_consecutive_vertical(4) == [
    [0, 4, 8],  [1, 5, 9],  [2, 6, 10],  [3, 7, 11],
    [4, 8, 12], [5, 9, 13], [6, 10, 14], [7, 11, 15]]

assert grid_consecutive_incline_right(4) == [
    [0, 5, 10], [1, 6, 11],
    [4, 9, 14], [5, 10, 15]]

assert grid_consecutive_incline_left(4) == [
    [2, 5, 8], [3, 6, 9],
    [6, 9, 12], [7, 10, 13]]

assert grid_consecutive_vertical(5) == [
     [0, 5, 10],   [1, 6, 11],   [2, 7, 12],   [3, 8, 13],   [4, 9, 14],
     [5, 10, 15],  [6, 11, 16],  [7, 12, 17],  [8, 13, 18],  [9, 14, 19],
     [10, 15, 20], [11, 16, 21], [12, 17, 22], [13, 18, 23], [14, 19, 24]]

assert grid_consecutive_incline_right(5) == [
    [0, 6, 12], [1, 7, 13], [2, 8, 14],
    [5, 11, 17], [6, 12, 18], [7, 13, 19],
    [10, 16, 22], [11, 17, 23], [12, 18, 24]]

assert grid_consecutive_incline_left(5) == [
    [2, 6, 10], [3, 7, 11], [4, 8, 12],
    [7, 11, 15], [8, 12, 16], [9, 13, 17],
    [12, 16, 20], [13, 17, 21], [14, 18, 22]]

println "tests pass"
