package project.euler.problems

class Benchmark {
    static def run(closure) {
      def start = System.currentTimeMillis()
      closure.call()
      def now = System.currentTimeMillis()
      now - start
    }
}
