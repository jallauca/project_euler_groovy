package project.euler.problems

import org.junit.*

class Problem_06Test {
  @Test
  void smalllest_multiple_produces_correct_results() {
    assert new Problem_06().sum_of_squares( (1..10) ) == 385
    assert new Problem_06().square_of_sums( (1..10 ) ) == 3025
    assert new Problem_06().sum_square_difference( (1..10) ) == 2640
    assert new Problem_06().sum_square_difference( (1..100) ) == 25164150
  }
}

