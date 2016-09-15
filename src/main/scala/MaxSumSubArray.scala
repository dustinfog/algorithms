/**
  * Created by panzd on 9/14/16.
  * 3.求子数组的最大和
  * 题目：
  * 输入一个整形数组，数组里有正数也有负数。
  * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
  * 求所有子数组的和的最大值。要求时间复杂度为O(n)。

  * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
  * 因此输出为该子数组的和18。
  */
object MaxSumSubArray extends App {
  var array : Array[Int] = Array(1, -2, 3, 10, -4, 7, 2, -5)

  println(findMaxSum(array))

  def findMaxSum(array: Array[Int]): (Int, Int, Int) = {
    var maxSum : Int = 0
    var maxFrom : Int = 0
    var maxTo : Int = 0

    var sum : Int = 0
    var from : Int = 0
    for (i <- array.indices) {
      sum = sum + array(i)
      if (sum > maxSum) {
        maxSum = sum
        maxFrom = from
        maxTo = i
      } else if (sum < 0 ){
        sum = 0
        from = i + 1
      }
    }

    (maxSum, maxFrom, maxTo)
  }
}
