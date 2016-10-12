/**
  * Created by panzd on 12/10/2016.
  *
  * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
  * 例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
  * 分析：这是一道广为流传的google面试题。
  *
  */
object CountDecimalOnes {
  def main(args: Array[String]): Unit = {
    buildTable()
    println(count(130))
  }

  def count(n : Int) : Int = if (n != 0) {
    val m = getMagnitude(n)
    if (m == 0) {
      1
    } else {
      val i = Math.pow(10, m).toInt
      val f = n / i
      val r = n % i

      val b = if (f > 1) i else r + 1
      b + (f - 1) * table(m - 1) + count(r)
    }
  } else {
    0
  }

  private var table : Array[Int] = _
  def buildTable() : Unit = {
    val maxMagnitude = getMagnitude(Int.MaxValue)
    table = new Array[Int](maxMagnitude + 1)
    table(0) = 1

    for(i <- 1 to maxMagnitude){
      table(i) = Math.pow(10, i).toInt + 10 * table(i - 1)
    }
  }

  def getMagnitude(n : Int): Int = Math.log10(n).toInt
}
