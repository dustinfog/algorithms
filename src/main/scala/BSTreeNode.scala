/**
  * Created by panzd on 9/15/16.
  */
case class BSTreeNode(var value: Int, var left: Option[BSTreeNode] = None, var right: Option[BSTreeNode] = None)

object BSTreeNode {
  implicit def node2Option(node : BSTreeNode) : Option[BSTreeNode] = Some(node)
  implicit def Int2Node(i: Int): Option[BSTreeNode] = BSTreeNode(i)
  implicit def Option2Node(option: Option[BSTreeNode]) : BSTreeNode = option.get

  def printNode(node: Option[BSTreeNode], prefix : String = ""): Unit = if (node.isDefined) {
    println(prefix + node.value)
    printNode(node.left, prefix + " ")
    printNode(node.right, prefix + " ")
  }
}
