/**
  * Created by panzd on 9/22/16.
  * 题目：求1+2+…+n，
  * 要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句（A?B:C）。
  */
object ConsecutivePlus {
 def main(args: Array[String]): Unit = {
   print(plusConsecutively(10))
 }

 def plusConsecutively(n : Int) : Int = n + plusConsecutively(n - 1)
}
