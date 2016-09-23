/**
  * 微软亚院之编程判断俩个链表是否相交
  * 给出俩个单向链表的头指针，比如h1，h2，判断这俩个链表是否相交。
  * 为了简化问题，我们假设俩个链表均不带环。

  * 问题扩展：
  * 1. 如果链表可能有环列?
  * 2. 如果需要求出俩个链表相交的第一个节点列?
  */
object IntersectCheck {
  def main(args: Array[String]): Unit = {
    val intersect = SLLNode(2, SLLNode(3, SLLNode(3)))

    val h1 : SLLNode = SLLNode(1, intersect)
    val h2 : SLLNode = SLLNode(5, SLLNode(6, intersect))

    val t1 = findTail(h1)
    val t2 = findTail(h2)
    if (t1 == t2) {
      println("1. intersected")
    }

  }

  def findCircleStart(h : SLLNode) : SLLNode = {
    //@todo need implements
    null
  }

  def findTail(h : SLLNode): SLLNode = {
    var node = h
    while(node.next != null) {
      node = node.next
    }
    node
  }
}

