

/**
  * Created by panzd on 9/25/16.
  * 第15题：
  * 题目：输入一颗二元查找树，将该树转换为它的镜像，
  * 即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
  * 用递归和循环两种方法完成树的镜像转换。
  * 例如输入：
  *    8
  *   / \
  *   6 10
  *  /\ /\
  * 5 7 9 11
  *
  * 输出：
  *    8
  *   / \
  *  10 6
  *  /\ /\
  * 11 9 7 5
  *
  * 定义二元查找树的结点为：
  * struct BSTreeNode // a node in the binary search tree (BST)
  * {
  *  int m_nValue; // value of node
  *  BSTreeNode *m_pLeft; // left child of node
  *  BSTreeNode *m_pRight; // right child of node
  * };
  */
object TreeImage {
  def main(args: Array[String]): Unit = {
    import BSTreeNode._
    val tree = BSTreeNode(8,
      BSTreeNode(6, 5, 7),
      BSTreeNode(10, 9, 11)
    )

    //imageTreeRecursively(tree)
    imageTreeLooping(tree)
    printNode(tree)
  }

  def imageTreeLooping(tree: BSTreeNode): Unit = {
    var stack = tree::Nil
    while(stack.nonEmpty) {
      val node = stack.head
      stack = stack.tail

      val leftNode = node.left
      val rightNode = node.right

      val tmp = leftNode
      node.left = rightNode
      node.right = tmp

      leftNode.foreach(l => {
        stack = l :: stack
      })

      rightNode.foreach(r => {
        stack = r :: stack
      })
    }
  }

  def imageTreeRecursively(tree : BSTreeNode): Unit ={
    val leftNode = tree.left
    val rightNode = tree.right

    val tmp = leftNode
    tree.left = rightNode
    tree.right = tmp

    leftNode.foreach(l => {
      imageTreeRecursively(l)
    })
    rightNode.foreach(r => {
      imageTreeRecursively(r)
    })
  }
}
