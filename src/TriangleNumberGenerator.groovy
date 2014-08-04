package project.euler.problems

class TriangleNumberGenerator implements Iterator<Long> {
  def summand = 0
  def triangleNumber = 0

  public boolean hasNext() {
    return true;
  }

  public Long next() {
    summand += 1
    triangleNumber += summand
    triangleNumber
  }

  private Long generate_next() {
  }

  public void remove() {
    throw new UnsupportedOperationException("Remove is not supported on generators");
  }
}
