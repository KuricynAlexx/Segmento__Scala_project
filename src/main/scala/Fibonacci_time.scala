object Fibonacci_time {
  def time[R](block: => R)(func_name: String): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println(s"Elapsed time ($func_name): " + (t1 - t0) + " ns")
    result
  }

  def main(args: Array[String]): Unit = {
    val fibonacci = new Fibonacci()
    val N : Int = 10
    time {fibonacci.calc_For(N)}("Loop For")

    time {fibonacci.recursion(N)}("recursion")

    time {fibonacci.calc_tailrec(N)}("tailrec")
  }
}