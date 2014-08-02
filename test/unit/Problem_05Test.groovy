package project.euler.problems

import org.junit.*

class Problem_05Test {
  @Test
  void smalllest_multiple_produces_correct_results() {
    assert new Problem_05().smallest_multiple( (1..10) ) == 2520
    assert new Problem_05().smallest_multiple( (1..20) ) == 232792560
  }
}

