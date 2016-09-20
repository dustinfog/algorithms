/**
  * 翻转句子中单词的顺序。
  * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
  * 句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
  * 例如输入“I am a student.”，则输出“student. a am I”。
  */
import ArrayUtil._
object RevertWordsOrder {
  def main(args: Array[String]): Unit = {
    val chars : Array[Char] = Array('I',' ','a','m',' ','a',' ','s','t','u','d','e','n','t','.')

    reverse(chars)

    var wordStart = 0
    for(i <- chars.indices) {
      if (chars(i) == ' ') {
        reverse(chars, wordStart, i)
        wordStart = i + 1
      }
    }

    if (chars(chars.length - 1) != ' ') {
      reverse(chars, wordStart, chars.length)
    }

    printArray(chars)
  }
}
