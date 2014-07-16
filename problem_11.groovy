evaluate(new File("IterableMonkeyPatch.groovy"))

Iterable.metaClass.eachConsecutive = { int n, step = 1 ->
    max_index = delegate.size()-(step * (n - 1))
    (0..<max_index).collect {
        range = (it..it+n*(step-1)).step(step)
        delegate[range]
    }
}

grid_count = 4
consecutive = 3

def number_grid(n) { (0..<n.power(2)) }

def grid_consecutive_incline_right = { int n, step = 3 ->
    number_grid(n)
    .eachConsecutive(step, n)
    .collect { x,y,z -> [x, y+1, z+2] }
    .findAll { x,y,z -> x<n.power(2) && y<n.power(2) && z<n.power(2) && x % n < n-step+1 }
}

assert number_grid(3).eachConsecutive(3, 3) == [
    [0, 3, 6], [1, 4, 7], [2, 5, 8]]

assert (grid_consecutive_incline_right(3)) == [[0, 4, 8]]

assert number_grid(4).eachConsecutive(3, 4) == [
    [0, 4, 8],  [1, 5, 9],  [2, 6, 10],  [3, 7, 11],
    [4, 8, 12], [5, 9, 13], [6, 10, 14], [7, 11, 15]]

assert (grid_consecutive_incline_right(4)) == [
    [0, 5, 10], [1, 6, 11],
    [4, 9, 14], [5, 10, 15]]

assert number_grid(5).eachConsecutive(3, 5) == [
     [0, 5, 10],   [1, 6, 11],   [2, 7, 12],   [3, 8, 13],   [4, 9, 14],
     [5, 10, 15],  [6, 11, 16],  [7, 12, 17],  [8, 13, 18],  [9, 14, 19],
     [10, 15, 20], [11, 16, 21], [12, 17, 22], [13, 18, 23], [14, 19, 24]]

assert (grid_consecutive_incline_right(5)) == [
    [0, 6, 12], [1, 7, 13], [2, 8, 14],
    [5, 11, 17], [6, 12, 18], [7, 13, 19],
    [10, 16, 22], [11, 17, 23], [12, 18, 24]]

println "tests pass"
