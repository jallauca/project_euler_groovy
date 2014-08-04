package project.euler.problems

import org.junit.*

class TriangleNumberGeneratorTest {
  @Test
  void generator() {
    def c = 1
    assert new TriangleNumberGenerator().take(7).collect() == [1,3,6,10,15,21,28]
  }
}
