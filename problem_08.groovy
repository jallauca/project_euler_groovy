Iterable.metaClass.eachConsecutive = { int n ->
    (0..delegate.size()-n).collect{ delegate[it..it+n-1] }
}

assert [1,2,3,4,5,6].eachConsecutive(2) == [[1,2], [2,3], [3,4], [4,5], [5,6]]
assert [1,2,3,4,5,6].eachConsecutive(3) == [[1,2,3], [2,3,4], [3,4,5], [4,5,6]]
assert [1,2,3,4,5,6].eachConsecutive(4) == [[1,2,3,4], [2,3,4,5], [3,4,5,6]]
