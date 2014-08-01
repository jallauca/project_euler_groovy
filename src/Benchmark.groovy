package project.euler.problems

class Benchmark {
    static def run(closure) {
      def start = System.currentTimeMillis()
      closure.call()
      def now = System.currentTimeMillis()
      now - start
    }

    static void main(String[] args) {
        new Benchmark().run {
            println "tests pass"
        }
    }
}
