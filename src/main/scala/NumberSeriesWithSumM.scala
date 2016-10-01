/**
  * Created by panzd on 9/30/16.
  * 2010年中兴面试题
  * 编程求解：
  * 输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,
  * 使其和等于 m ,要求将其中所有的可能组合列出来.
  *
  * 1,2,3,4,5
  */
object NumberSeriesWithSumM {
  def main(args: Array[String]): Unit = {
    for(res <- find(5, 13)) {
      println(res)
    }
  }

  def find(n : Int, m : Int) : List[List[Int]] = {
    var ret:List[List[Int]] = Nil
    for (i <- 2 until n) {
      ret = findK(i, 1, n, m) ::: ret
    }

    ret
  }

  def findK(k : Int, begin : Int, end : Int, sum : Int): List[List[Int]] = {
    var ret:List[List[Int]] = Nil

    val maxRes = (sum * 2 / k + 1 - k) / 2
    val minRes = Math.max(sum - (2 * end - k + 2) * (k - 1) / 2, begin)

    if (k == 2) {
      for (i <- minRes to maxRes) {
        ret = (i :: (sum - i) :: Nil) :: ret
      }
    } else {
      for (i <- minRes to maxRes) {
        for(subSubRet <- findK(k - 1, i + 1, end, sum - i)) {
          ret = (i :: subSubRet) :: ret
        }
      }
    }

    ret
  }
}
