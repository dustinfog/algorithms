/**
  * Created by panzd on 9/23/16.
  * 题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
  * 链表结点定义如下：
  * struct ListNode
  * {
  *   int m_nKey;
  *   ListNode* m_pNext;
  * };
  */
object ReciprocalElement {
  def main(args: Array[String]): Unit = {
    val k = 3
    val list = SLLNode(1, SLLNode(2, SLLNode(3, SLLNode(4, SLLNode(5)))))

    println(seek(list, k).value)
  }


  def seek(list : SLLNode[Int], k : Int): SLLNode[Int] = {
    var node = list
    var i : Int = 1
    var candidate : SLLNode[Int] = null
    while(node != null) {
      node = node.next

      if (i < k) {
        i = i + 1
      } else if (candidate == null) {
        candidate = list
      } else {
        candidate = candidate.next
      }
    }

    candidate
  }
}
