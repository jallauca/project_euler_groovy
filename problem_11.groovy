evaluate(new File("IterableMonkeyPatch.groovy"))

def numbers_test_string = """
08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
"""

def number_grid(n) { (0..<n.power(2)) }

def consecutive_horizontal = { int n, int cons = 3, int grid_size ->
  ( n.div(grid_size) as int == (n+cons-1).div(grid_size) as int ) ?
  ( n..n+cons-1).collect() : []
}

def consecutive_vertical = { int n, int cons = 3, int grid_size ->
  ( n + grid_size*(cons-1) < grid_size.power(2) ) ?
  (n..n + grid_size*(cons-1)).step(grid_size) : []
}

def consecutive_incline_upper_left = { int n, int cons = 3, int grid_size ->
  if ( n % grid_size >= grid_size - cons + 1 ) []

  vertical = consecutive_vertical(n, cons, grid_size)
  return [vertical, (0..100)].transpose().collect { it.sum() }
}

def consecutive_incline_upper_right = { int n, int cons = 3, int grid_size ->
  if ( n % grid_size <= cons - 2 ) []

  vertical = consecutive_vertical(n, cons, grid_size)
  return [vertical, (0..-100)].transpose().collect { it.sum() }
}

def product_of_each = { List<Integer> ns ->
  ns.inject(1) { seed, n -> (seed * n) as long }
}

def numbers = numbers_test_string.stripIndent().split(/\s/)[1..-1]
              .collect { it.toString().toInteger()  }

def grid_size = 20
def cons = 4

def max_all_directions = number_grid(grid_size)
        .collect { n ->
          [consecutive_horizontal(n, cons, grid_size),
           consecutive_vertical(n, cons, grid_size),
           consecutive_incline_upper_left(n, cons, grid_size),
           consecutive_incline_upper_right(n, cons, grid_size)] }
        .flatten()
        .collate(4)
        .collect { it.findAll { it < grid_size.power(2) } }
        .collect { idx -> product_of_each( numbers[idx] ) }
        .max()

assert max_all_directions == 70600674
println "answer=$max_all_directions"






assert consecutive_horizontal(0, 3, 9) == [0, 1, 2]
// assert consecutive_horizontal(1, 3, 9) == []
// assert consecutive_horizontal(2, 3, 9) == [[0, 1, 2], [3, 4, 5], [6, 7, 8]]

// assert grid_consecutive_vertical(3) == [[0, 3, 6], [1, 4, 7], [2, 5, 8]]
// assert grid_consecutive_incline_upper_left(3) == [[0, 4, 8]]
// assert grid_consecutive_incline_upper_right(3) == [[2, 4, 6]]

// assert grid_consecutive_horizontal(4) == [
//   [0, 1, 2], [1, 2, 3],
//   [4, 5, 6], [5, 6, 7],
//   [8, 9, 10], [9, 10, 11],
//   [12, 13, 14], [13, 14, 15]]

// assert grid_consecutive_vertical(4) == [
//   [0, 4, 8],  [1, 5, 9],  [2, 6, 10],  [3, 7, 11],
//   [4, 8, 12], [5, 9, 13], [6, 10, 14], [7, 11, 15]]

// assert grid_consecutive_incline_upper_left(4) == [
//   [0, 5, 10], [1, 6, 11],
//   [4, 9, 14], [5, 10, 15]]

// assert grid_consecutive_incline_upper_right(4) == [
//   [2, 5, 8], [3, 6, 9],
//   [6, 9, 12], [7, 10, 13]]

// assert grid_consecutive_horizontal(5) == [
//   [0, 1, 2], [1, 2, 3], [2, 3, 4],
//   [5, 6, 7], [6, 7, 8], [7, 8, 9],
//   [10, 11, 12], [11, 12, 13], [12, 13, 14],
//   [15, 16, 17], [16, 17, 18], [17, 18, 19],
//   [20, 21, 22], [21, 22, 23], [22, 23, 24]]

// assert grid_consecutive_vertical(5) == [
//   [0, 5, 10],   [1, 6, 11],   [2, 7, 12],   [3, 8, 13],   [4, 9, 14],
//   [5, 10, 15],  [6, 11, 16],  [7, 12, 17],  [8, 13, 18],  [9, 14, 19],
//   [10, 15, 20], [11, 16, 21], [12, 17, 22], [13, 18, 23], [14, 19, 24]]

// assert grid_consecutive_incline_upper_left(5) == [
//   [0, 6, 12], [1, 7, 13], [2, 8, 14],
//   [5, 11, 17], [6, 12, 18], [7, 13, 19],
//   [10, 16, 22], [11, 17, 23], [12, 18, 24]]

// assert grid_consecutive_incline_upper_right(5) == [
//   [2, 6, 10], [3, 7, 11], [4, 8, 12],
//   [7, 11, 15], [8, 12, 16], [9, 13, 17],
//   [12, 16, 20], [13, 17, 21], [14, 18, 22]]

// def indexes = grid_consecutive_incline_upper_left(10,4)
// assert [indexes[0], indexes[-1]] == [[0, 11, 22, 33], [66, 77, 88, 99]]

// indexes = grid_consecutive_incline_upper_right(10,4)
// assert [indexes[0], indexes[-1]] == [[3, 12, 21, 30], [69, 78, 87, 96]]

// indexes = grid_consecutive_vertical(10,4)
// assert [indexes[0], indexes[-1]] == [[0, 10, 20, 30], [69, 79, 89, 99]]

// indexes = grid_consecutive_incline_upper_left(20,4)
// assert [indexes[0], indexes[-1]] == [[0, 21, 42, 63], [336, 357, 378, 399]]

println "tests pass"
