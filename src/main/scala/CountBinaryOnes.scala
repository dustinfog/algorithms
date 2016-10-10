/**
  * Created by panzd on 10/10/2016.
  * 输入一个整数，求该整数的二进制表达中有多少个1。
  * 例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
  */
object CountBinaryOnes {
  def main(args: Array[String]): Unit = {
    println(count(511))
    println(count1(511))
    println(count2(511))
  }

  def count(number : Int) : Int = {
    var tmp = number
    var ret = 0
    while (tmp != 0) {
      if ((tmp & 1) == 1) {
        ret = ret + 1
      }

      tmp = tmp >>> 1
    }

    ret
  }

  def count1(number : Int) : Int = {
    var tmp = number
    var ret = 0
    while (tmp != 0) {
      ret = ret + 1
      tmp = tmp & (tmp - 1)
    }

    ret
  }

  def count2(number : Int) : Int = {
    buildTable()
    countWithTable(number)
  }

  private var table : Array[Int] = _
  private def buildTable() : Unit = if (table == null) {
    table = new Array[Int](256)
    table(0) = 0
    for (i <- table.indices) {
      table(i) = ( i & 1 ) + table(i / 2)
    }
  }

  private def countWithTable(number : Int) = {
    var ret = 0
    var tmp = number
    while (tmp != 0) {
      ret += table(tmp & 0xff)

      tmp = tmp >>> 8
    }
    ret
  }
}
