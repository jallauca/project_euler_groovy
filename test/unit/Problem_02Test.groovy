package project.euler.problems

import org.junit.*

class Problem_02Test {
  @Test
  void fibonacci_produces_correct_results() {
    assert new Problem_02().fibonacci(-4) == []
    assert new Problem_02().fibonacci(0) == []
    assert new Problem_02().fibonacci(1) == [1]
    assert new Problem_02().fibonacci(2) == [1,2]
    assert new Problem_02().fibonacci(4000000).findAll { it % 2  == 0 }.sum() == 4613732
  }
}
