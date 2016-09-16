import scala.util.Random

/**
  *
  * 查找最小的k个元素
  * 题目：输入n个整数，输出其中最小的k个。
  * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
  */
object MinKNumbers {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    shuffle(numbers)
    findK(numbers, 0, numbers.length, 6)
    printArray(numbers, 0, 6)
  }

  def findK(numbers : Array[Int], from : Int, to : Int, k : Int) : Unit = if (from != to) {
    val ref = numbers(from)
    var largerIndex = to - 1
    var i : Int = from + 1
    while (i <= largerIndex) {
      val value = numbers(i)
      if (value < ref) {
        exchange(numbers, i - 1, i)
        i = i + 1
      } else {
        exchange(numbers, i, largerIndex - 1)
        largerIndex = largerIndex - 1
      }
    }

    if (largerIndex > k) {
      findK(numbers, from, largerIndex, k)
    } else if (largerIndex < k) {
      findK(numbers, largerIndex, to, k)
    }
  }

  def shuffle(numbers : Array[Int]) : Unit = {
    val count = numbers.length
    for (i <- numbers.indices) {
      exchange(numbers, i, Random.nextInt(count))
    }
  }

  def printArray[T](array:Array[T], from : Int = 0, to : Int = -1) : Unit = {
    var target = to
    if (to < 0) {
      target = array.length
    }

    for (i <- from until target) {
      print(array(i))
      if (i != target - 1) {
        print(',')
      }
    }
    println
  }

  def exchange(numbers : Array[Int], from : Int, to : Int): Unit = {
    val value = numbers(from)
    numbers(from) = numbers(to)
    numbers(to) = value
  }
}
