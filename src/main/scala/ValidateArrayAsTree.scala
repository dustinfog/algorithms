/**
  * Created by panzd on 9/19/16.
  *
  * 判断整数序列是不是二元查找树的后序遍历结果
  * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。
  * 如果是返回true，否则返回false。
  *
  * 例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：
  *       8
  *      / \
  *    6    10
  *   / \  / \
  *  5  7 9 11
  * 因此返回true。
  * 如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。
  *
  */
object ValidateArrayAsTree {
  def main(args: Array[String]): Unit = {
    val numbers : Array[Int] = Array(5, 7, 6, 9, 11, 10, 8)

    println(validate(numbers, 0, numbers.length))


    val numbers1 : Array[Int] = Array(7, 4, 6, 5)

    println(validate(numbers1, 0, numbers1.length))
  }

  def validate(numbers : Array[Int], from : Int, to : Int): Boolean = if (from != to - 1) {
    val lastIndex = to - 1
    val rootCandidate = numbers(lastIndex)
    var criticalIndex = lastIndex
    var validRoot : Boolean = true
    for (i <- from until lastIndex if validRoot) {
      val number = numbers(i)
      if (criticalIndex != lastIndex && number < rootCandidate) {
        validRoot = false
      } else if (criticalIndex == lastIndex && number > rootCandidate) {
        criticalIndex = i
      }
    }

    if (validRoot) {
      validate(numbers, from, criticalIndex) && validate(numbers, criticalIndex, lastIndex)
    } else {
      false
    }
  } else {
    true
  }
}
