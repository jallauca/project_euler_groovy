public class Benchmark {
    public static def run(closure) {
      def start = System.currentTimeMillis()
      closure.call()
      def now = System.currentTimeMillis()
      now - start
    }

    public static void main(String[] args) {
        new Benchmark().run {
            println "tests pass"
        }
    }
}
