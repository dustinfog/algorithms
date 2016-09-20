import scala.util.Random

/**
  * Created by panzd on 9/16/16.
  */
object ArrayUtil {

  def shuffle[T](numbers : Array[T]) : Unit = {
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

  def exchange[T](numbers : Array[T], from : Int, to : Int): Unit = {
    val value = numbers(from)
    numbers(from) = numbers(to)
    numbers(to) = value
  }

  def reverse[T](array : Array[T], from : Int, to : Int): Unit = {
   for (i <- from until to / 2) {
     exchange(array, i, to - i -1)
   }
  }

  def reverse[T](array: Array[T]): Unit = {
    reverse(array, 0, array.length)
  }

  def main(args: Array[String]): Unit = {
    val array : Array[Int] = Array(1, 2, 3, 4)
    reverse(array)
    printArray(array)
  }
}
