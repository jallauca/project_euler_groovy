package project.euler.problems

import org.junit.*

class Problem_08Test {
  @Test
  void largest_product_in_series() {
    assert new Problem_08().largest_product_in_series(4) == 5832
    assert new Problem_08().largest_product_in_series(13) == 23514624000
  }
}

