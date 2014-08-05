package project.euler.problems

import org.junit.*

class IterableMonkeyPatchTest {
  def csny

  public IterableMonkeyPatchTest() {
    IterableMonkeyPatch.apply()
    csny = [ "Crosby", "Stills", "Nash", "Young", "Bill" ]
  }

  @Test
  void eachConsecutive_2() {
    assert [1,2,3,4,5,6].eachConsecutive(2) == [[1,2], [2,3], [3,4], [4,5], [5,6]]
  }

  @Test
  void eachConsecutive_3() {
    assert [1,2,3,4,5,6].eachConsecutive(3) == [[1,2,3], [2,3,4], [3,4,5], [4,5,6]]
  }

  @Test
  void eachConsecutive_4() {
    assert [1,2,3,4,5,6].eachConsecutive(4) == [[1,2,3,4], [2,3,4,5], [3,4,5,6]]
  }

  @Test
  void kCombinations_0() {
    assert csny.kCombinations(0) == [[]]
  }

  @Test
  void kCombinations_1() {
    assert csny.kCombinations(1) ==
      [["Crosby"], ["Stills"], ["Nash"], ["Young"], ["Bill"]]
  }

  @Test
  void kCombinations_2() {
    assert csny.kCombinations(2) ==
      [["Crosby", "Stills"], ["Crosby", "Nash"], ["Crosby", "Young"], ["Crosby", "Bill"],
      ["Stills", "Nash"], ["Stills", "Young"], ["Stills", "Bill"],
      ["Nash", "Young"], ["Nash", "Bill"],
      ["Young", "Bill"]]
  }

  @Test
  void kCombinations_3() {
    assert csny.kCombinations(3) ==
      [["Crosby", "Stills", "Nash"], ["Crosby", "Stills", "Young"],
      ["Crosby", "Stills", "Bill"], ["Crosby", "Nash", "Young"],
      ["Crosby", "Nash", "Bill"], ["Crosby", "Young", "Bill"],
      ["Stills", "Nash", "Young"], ["Stills", "Nash", "Bill"], ["Stills", "Young", "Bill"],
      ["Nash", "Young", "Bill"]]
  }

  @Test
  void kCombinations_4() {
    assert csny.kCombinations(4) ==
      [["Crosby", "Stills", "Nash", "Young"], ["Crosby", "Stills", "Nash", "Bill"],
      ["Crosby", "Stills", "Young", "Bill"], ["Crosby", "Nash", "Young", "Bill"],
      ["Stills", "Nash", "Young", "Bill"]]
  }

  @Test
  void kCombinations_5() {
    assert csny.kCombinations(5) ==
      [["Crosby", "Stills", "Nash", "Young", "Bill"]]
  }
}
