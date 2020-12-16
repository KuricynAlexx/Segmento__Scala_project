import org.scalatest.funsuite.AnyFunSuite

class FibonacciTest extends org.scalatest.funsuite.AnyFunSuite {
/* Для простоты считаем, что первые два числа не имеют номеров,
    и при n=1 => Fibonacci(1) = 2
 */
  test("testRecursion") {
    val obj=new Fibonacci()
    // #1
    var res=obj.recursion(1)
    assert(res == 2)
    // #2
    res=obj.recursion(10)
    assert(res == 144)
    // #3
    res=obj.recursion(12)
    assert(res == 377)
    // #4
    res=obj.recursion(17)
    assert(res == 4181)

  }

  test("testCalc_For") {
    val obj = new Fibonacci()
    var res = obj.calc_For(1)
    // #1
    assert(res == 2)
    // #2
    res=obj.calc_For(10)
    assert(res == 144)
    // #3
    res=obj.calc_For(12)
    assert(res == 377)
    // #4
    res=obj.calc_For(17)
    assert(res == 4181)
  }

  test("testCalc_tailrec") {
    val obj = new Fibonacci()
    var res = obj.calc_tailrec(1)
    // #1
    assert(res == 2)
    // #2
    res=obj.calc_tailrec(10)
    assert(res == 144)
    // #3
    res=obj.calc_tailrec(12)
    assert(res == 377)
    // #4
    res=obj.calc_tailrec(17)
    assert(res == 4181)
  }
}
