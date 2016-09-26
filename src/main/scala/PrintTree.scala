/**
  * Created by panzd on 9/26/16.
  *
  * 第16题：
  * 题目（微软）：
  * 输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
  * 例如输入
  *      8
  *    /  \
  *   6   10
  *  / \  / \
  * 5  7 9 11
  *
  * 输出8 6 10 5 7 9 11。
  */
object PrintTree {
  def main(args: Array[String]): Unit = {
    val tree = BSTreeNode(8,
      BSTreeNode(6, 5, 7),
      BSTreeNode(10, 9, 11)
    )

    var sllNode = SLLNode(tree)
    var tail = sllNode
    while(sllNode != null) {
      val treeNode = sllNode.value
      print(treeNode.value)
      print(' ')

      treeNode.left.foreach(l => {
        val newNode = SLLNode(l)
        tail.next = newNode
        tail = newNode
      })

      treeNode.right.foreach(r => {
        val newNode = SLLNode(r)
        tail.next = newNode
        tail = newNode
      })

      sllNode = sllNode.next
    }
  }


}
