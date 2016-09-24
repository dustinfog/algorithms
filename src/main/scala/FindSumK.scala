/**
  * Created by panzd on 9/24/16.
  * 输入一个已经按升序排序过的数组和一个数字，
  * 在数组中查找两个数，使得它们的和正好是输入的那个数字。
  * 要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
  * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
  */
object FindSumK {
  def main(args: Array[String]): Unit = {
    val arr : Array[Int] = Array(1, 2, 4, 7, 11, 15)
    val result = find(arr, 19)

    println(result)
  }

  def find(arr : Array[Int], k : Int) : (Int, Int) = {
    var i = 0
    var j = arr.length - 1
    var found = false

    while(j > i && !found) {
      val sum = arr(j) + arr(i)
      if (sum < k) {
        i = i + 1
      } else if (sum > k) {
        j = j - 1
      } else {
        found = true
      }
    }

    if (found) {
      (i, j)
    } else {
      null
    }
  }
}
