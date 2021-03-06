/**
  * Created by panzd on 9/12/16.
  */

object BSTree2BLList {

  def main(args: Array[String]): Unit = {
    //     10
    //    /   \
    //   6    14
    //  / \   / \
    // 4   8 12 16
    val tree = BSTreeNode(10,
      BSTreeNode(6, 4, 8),
      BSTreeNode(14, 12, 16)
    )

    var (node, _) = transform(tree)
    while (node.isDefined ) {
      println(node.value)
      node = node.right
    }
  }

  def transform(node: BSTreeNode): (Option[BSTreeNode], Option[BSTreeNode]) = {
    var leftMost : Option[BSTreeNode] = node
    val leftNode = node.left
    leftNode.foreach { l => {
      val (leftLeftMost, leftRightMost) = transform(l)
      leftRightMost.right = node
      node.left = leftRightMost
      leftMost = leftLeftMost
    } }

    var rightMost : Option[BSTreeNode] = node
    val rightNode = node.right
    rightNode.foreach { r => {
      val (rightLeftMost, rightRightMost) = transform(r)
      node.right = rightLeftMost
      rightLeftMost.left = node
      rightMost = rightRightMost
    } }

    (leftMost, rightMost)
  }
}




