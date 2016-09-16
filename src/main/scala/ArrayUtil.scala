import scala.util.Random

/**
  * Created by panzd on 9/16/16.
  */
object ArrayUtil {

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
