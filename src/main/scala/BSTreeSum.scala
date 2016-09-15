/**
  * Created by panzd on 9/15/16.
  * 4.在二元树中找出和为某一值的所有路径
  * 题目：输入一个整数和一棵二元树。
  * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
  * 打印出和与输入整数相等的所有路径。
  * 例如 输入整数22和如下二元树
  *     10
  *    / \
  *   5  12
  *  / \
  * 4  7
  * 则打印出两条路径：10, 12和10, 5, 7。
  */
object BSTreeSum {
  def main(args: Array[String]): Unit = {
    val Goal = 22

    val tree = BSTreeNode(10,
      BSTreeNode(5, 4, 7),
      12
    )

    val node = sumNode(tree)

    BSTreeNode.printNode(node)
  }

  def sumNode(node: Option[BSTreeNode], sum: Int = 0): Option[BSTreeNode] =
    if (node.isEmpty) {
      None
    } else {
      val value = node.value
      val newSum = sum + value

      if (newSum > Goal) {
        None
      } else if (newSum == Goal) {
        value
      } else {
        var ret: Option[BSTreeNode] = None
        sumNode(node.left, newSum).foreach(node => {
          ret = Some(BSTreeNode(value))
          ret.left = node
        })

        sumNode(node.right, newSum).foreach(node => {
          if (ret.isEmpty) ret = Some(BSTreeNode(value))
          ret.right = node
        })

        ret
      }
    }
}
