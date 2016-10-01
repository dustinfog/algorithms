/**
  * Created by panzd on 9/30/16.
  * 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
  * 例如输入字符串"345"，则输出整数345。
  */
object Str2Int {
  def main(args: Array[String]): Unit = {
    println(str2Int("345"))
  }

  def str2Int(str : String): Int = {
    var res = 0
    var magnitude = 1
    for (i <- 0 until str.length reverse) {
      res += magnitude * (str.charAt(i) - '0')
      magnitude *= 10
    }

    res
  }
}
