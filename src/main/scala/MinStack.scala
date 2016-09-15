
import Predef._
/**
  * Created by panzd on 9/13/16.
  *
  * 定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
  * 要求函数min、push以及pop的时间复杂度都是O(1)。
  */
object MinStack extends App{
    val minStack = new MinStackStack[Int]
    minStack.push(4)
    minStack.push(2)
    minStack.push(3)
    minStack.push(5)
    minStack.push(1)

    minStack.pop()
    minStack.pop()
    minStack.pop()
    minStack.pop()
    println(minStack.min)
}

trait MStack[T]{
  def push(t : T) : Unit
  def pop() : Unit
  def min : T
  def top : T
}

class MinStackStack[T](implicit ordering: Ordering[T]) extends MStack[T] {
  var dataStack : List[T] = Nil
  var minStack : List[T] = Nil

  def push(t : T): Unit = {
    dataStack = t :: dataStack

    if (minStack.isEmpty || ordering.lteq(t, minStack.head)) {
      minStack = t :: minStack
    }
  }

  def pop() : Unit = {
    if (dataStack.head == minStack.head) {
      minStack = minStack.tail
    }

    dataStack = dataStack.tail
  }

  def min : T = minStack.head
  def top : T = dataStack.head
}
