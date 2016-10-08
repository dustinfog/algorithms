/**
  * Created by panzd on 10/8/16.
  * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。

  * 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
  * 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
  */
object StrRotateLeft {

  def main(args: Array[String]): Unit = {

    val chars : Array[Char] = "abcdef".toCharArray

    rotate(chars, 4)

    print(String.valueOf(chars))
  }

  def rotate(chars : Array[Char], n : Int): Unit = {
    if (n <= chars.length / 2) {
      for (i <- n until chars.length) {
        ArrayUtil.exchange(chars, i, i - n)
      }
    } else {
      val tailN = chars.length - n
      for (i <- 0 until n reverse) {
        ArrayUtil.exchange(chars, i, i + tailN)
      }
    }
  }
}
