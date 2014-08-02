package project.euler.problems

import org.junit.*

class Problem_09Test {
  @Test
  void pythagorean_triplet_produces_correct_results() {
    assert new Problem_09().pythagorean_triplet(3, 4, 5)
  }
}

