import scala.annotation.tailrec

class Fibonacci() {
  def calc_For(n: Int): Int = {
    var num1: Int = 1
    var num2: Int = 1
    var number : Int = 0

    for (i <- 1 to n) {
      number = num1 + num2
      num1 = num2
      num2 = number
    }
    number
  }

  def recursion(n: Int, num1: Int = 1, num2: Int = 1): Int = {
    if(n != 1) recursion(n-1, num2, num1+num2)
    else num1+num2
  }

  def calc_tailrec(n: Int): Int = {
    @tailrec
    def calc_inside(n: Int, num1: Int = 1, num2: Int = 1) : Int = {
      if(n != 1) calc_inside(n-1, num2, num1+num2)
      else num1+num2
    }
    calc_inside(n)
  }
}