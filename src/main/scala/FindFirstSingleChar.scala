/**
  * Created by panzd on 9/27/16.
  * 题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
  */
object FindFirstSingleChar {
  def main(args: Array[String]): Unit = {
    val str = "abaccdeff"

    println(find(str))
  }

  def find(str : String): Int = {

    val charCountMap : Array[Int] = new Array[Int](256)
    for (i <- 1 until str.length)
    {
      charCountMap(str.charAt(i)) += 1
    }

    var ret = -1
    for (i <- 1 until str.length if charCountMap(str.charAt(i)) == 1)
    {
      ret = i
    }

    ret
  }
}
