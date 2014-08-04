package project.euler.problems

import org.junit.*

class PrimeGeneratorTest {
  @Test
  void generator() {
    def c = 1
    assert new PrimeGenerator().takeWhile { c++ <= 5 }.collect() == [2,3,5,7,11]
  }
}
