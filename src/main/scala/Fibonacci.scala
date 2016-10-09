/**
  * Created by panzd on 9/29/16.
  * 题目：定义Fibonacci数列如下：
  * f(0) n=0
  * f(n)= 1 n=1
  * f(n-1)+f(n-2) n=2
  * 输入n，用最快的方法求该数列的第n项。
  * 0 1 1 2 3 5 8
  *
  */
object Fibonacci {
  def main(args: Array[String]): Unit = {
    val n = 4
    println(calculate(n))
  }

  def calculate(n : Int) : Int = {
    var res : Int = 0
    var prepre = 1
    var pre = 2
    for (i <- 3 to n) {
      res = pre + prepre
      prepre = pre
      pre = res
    }

    res
  }

  //todo: 矩阵运算
}
