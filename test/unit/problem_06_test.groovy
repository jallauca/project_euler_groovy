package project.euler.problems

import org.junit.*

class Problem_06Test {
  @Test
  void sum_of_squares() {
    assert new Problem_06().sum_of_squares( (1..10) ) == 385
  }

  @Test
  void square_of_sums() {
    assert new Problem_06().square_of_sums( (1..10 ) ) == 3025
  }

  @Test
  void sum_square_difference() {
    assert new Problem_06().sum_square_difference( (1..10) ) == 2640
    assert new Problem_06().sum_square_difference( (1..100) ) == 25164150
  }
}

