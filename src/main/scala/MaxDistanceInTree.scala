/**
  * Created by panzd on 9/21/16.
  * 求二叉树中节点的最大距离...

  * 如果我们把二叉树看成一个图，父子节点之间的连线看成是双向的，
  * 我们姑且定义"距离"为两节点之间边的个数。
  * 写一个程序，
  * 求一棵二叉树中相距最远的两个节点之间的距离。
  */
object MaxDistanceInTree {
  def main(args: Array[String]): Unit = {
    //     18
    //    /   \
    //   6    14
    //  / \   / \
    // 4   8 12 16
    val tree = BSTreeNode(10,
      BSTreeNode(6, 4, 8),
      BSTreeNode(14, 12, BSTreeNode(16, 15))
    )

    val (maxDistance, _) = findMaxDepthAndDistance(tree)
    println(maxDistance)
  }

  /**
    *
    * @param node
    * @return maxDistance, maxDepth
    */
  def findMaxDepthAndDistance(node : BSTreeNode) : (Int, Int) = {
    import Math._

    var tuple = (0, 0)
    node.left.foreach(left => {
      tuple = findMaxDepthAndDistance(left)
    })

    val (leftMaxDistance, leftDepth) = tuple

    tuple = (0, 0)
    node.right.foreach(right => {
      tuple = findMaxDepthAndDistance(right)
    })

    val (rightMaxDistance, rightDepth) = tuple

    val maxDistance = max(leftDepth + rightDepth, max(leftMaxDistance, rightMaxDistance))
    val maxDepth = max(leftDepth, rightDepth) + 1

    (maxDistance, maxDepth)
  }
}
