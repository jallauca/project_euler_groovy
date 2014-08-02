package project.euler.problems

import org.junit.*

class Problem_11Test {
  @Test
  void consecutive_3_by_3_produces_correct_results() {
    assert (0..9).collect { new Problem_11().consecutive_horizontal(it, 3, 3) } ==
      [[0, 1, 2], [],[], [3, 4, 5], [],[], [6, 7, 8], [],[],[]]
    assert (0..9).collect { new Problem_11().consecutive_vertical(it, 3, 3) } ==
      [[0, 3, 6], [1, 4, 7], [2, 5, 8], [],[],[],[],[],[],[]]
    assert (0..9).collect { new Problem_11().consecutive_incline_upper_right(it, 3, 3) } ==
      [[],[], [2, 4, 6], [],[],[],[],[],[],[]]
    assert (0..9).collect { new Problem_11().consecutive_incline_upper_left(it, 3, 3) } ==
      [[0, 4, 8], [],[],[],[],[],[],[],[],[]]
  }

  @Test
  void consecutive_3_by_4_produces_correct_results() {
    assert (0..16).collect { new Problem_11().consecutive_horizontal(it, 3, 4) } == [
      [0, 1, 2], [1, 2, 3], [],[],
      [4, 5, 6], [5, 6, 7], [],[],
      [8, 9, 10], [9, 10, 11], [],[],
      [12, 13, 14], [13, 14, 15], [],[],[] ]

    assert (0..16).collect { new Problem_11().consecutive_vertical(it, 3, 4) } == [
      [0, 4, 8],  [1, 5, 9],  [2, 6, 10],  [3, 7, 11],
      [4, 8, 12], [5, 9, 13], [6, 10, 14], [7, 11, 15],
      [],[],[],[],
      [],[],[],[],[]]

    assert (0..16).collect { new Problem_11().consecutive_incline_upper_left(it, 3, 4) } == [
      [0, 5, 10], [1, 6, 11],[],[],
      [4, 9, 14], [5, 10, 15],[],[],
      [],[],[],[],
      [],[],[],[],[]]

    assert (0..16).collect { new Problem_11().consecutive_incline_upper_right(it, 3, 4) } == [
      [],[],[2, 5, 8], [3, 6, 9],
      [],[],[6, 9, 12], [7, 10, 13],
      [],[],[],[],
      [],[],[],[],[]]
  }

  @Test
  void consecutive_3_by_5_produces_correct_results() {
    assert (0..25).collect { new Problem_11().consecutive_horizontal(it, 3, 5) } == [
      [0, 1, 2], [1, 2, 3], [2, 3, 4],[],[],
      [5, 6, 7], [6, 7, 8], [7, 8, 9],[],[],
      [10, 11, 12], [11, 12, 13], [12, 13, 14],[],[],
      [15, 16, 17], [16, 17, 18], [17, 18, 19],[],[],
      [20, 21, 22], [21, 22, 23], [22, 23, 24],[],[],[]]

    assert (0..25).collect { new Problem_11().consecutive_vertical(it, 3, 5) } == [
      [0, 5, 10],   [1, 6, 11],   [2, 7, 12],   [3, 8, 13],   [4, 9, 14],
      [5, 10, 15],  [6, 11, 16],  [7, 12, 17],  [8, 13, 18],  [9, 14, 19],
      [10, 15, 20], [11, 16, 21], [12, 17, 22], [13, 18, 23], [14, 19, 24],
      [],[],[],[],[],
      [],[],[],[],[],[]]

    assert (0..25).collect { new Problem_11().consecutive_incline_upper_left(it, 3, 5) } == [
      [0, 6, 12], [1, 7, 13], [2, 8, 14],[],[],
      [5, 11, 17], [6, 12, 18], [7, 13, 19],[],[],
      [10, 16, 22], [11, 17, 23], [12, 18, 24],[],[],
      [],[],[],[],[],
      [],[],[],[],[],[]]

    assert (0..25).collect { new Problem_11().consecutive_incline_upper_right(it, 3, 5) } == [
      [],[],[2, 6, 10], [3, 7, 11], [4, 8, 12],
      [],[],[7, 11, 15], [8, 12, 16], [9, 13, 17],
      [],[],[12, 16, 20], [13, 17, 21], [14, 18, 22],
      [],[],[],[],[],
      [],[],[],[],[],[]]
  }

  @Test
  void consecutive_4_by_10_produces_correct_results() {
    assert [0, 66].collect { new Problem_11().consecutive_incline_upper_left(it, 4, 10) } ==
      [[0, 11, 22, 33], [66, 77, 88, 99]]

    assert [3, 69].collect { new Problem_11().consecutive_incline_upper_right(it, 4, 10) } ==
      [[3, 12, 21, 30], [69, 78, 87, 96]]

    assert [0, 69].collect { new Problem_11().consecutive_vertical(it, 4, 10) } ==
      [[0, 10, 20, 30], [69, 79, 89, 99]]
  }

  @Test
  void consecutive_4_by_20_produces_correct_results() {
    assert [0, 336].collect { new Problem_11().consecutive_incline_upper_left(it, 4, 20) } ==
      [[0, 21, 42, 63], [336, 357, 378, 399]]
  }
}
