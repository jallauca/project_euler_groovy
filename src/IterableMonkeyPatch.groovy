package project.euler.problems

class IterableMonkeyPatch {
  static apply() {
    Iterable.metaClass.eachConsecutive = { int n ->
      (0..delegate.size()-n).collect{ delegate[it..it+n-1] }
    }

    Iterable.metaClass.tee = { closure ->
      if ( closure ) println closure(delegate)
      else println delegate
      delegate
    }

    // http://rosettacode.org/wiki/Combinations
    Iterable.metaClass.kCombinations = { int k1 ->
      def comb
      comb = { m, list ->
        def n = list.size()
        m == 0 ?
          [[]] :
          (0..(n-m)).inject([]) { newlist, k ->
            def sublist = (k+1 == n) ? [] : list[(k+1)..<n]
            newlist += comb(m-1, sublist).collect { [list[k]] + it }
          }
      }

      comb(k1, delegate)
    }
  }
}
