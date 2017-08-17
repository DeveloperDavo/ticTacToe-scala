object App {
  def main(args: Array[String]) {
    var board = Array(Array("x", " ", "o"),
      Array("x", "x", " "),
      Array(" ", "o", "o"))
    board.foreach { boardRow =>
      print("|")
      boardRow.foreach { boardElem =>
        print(boardElem + "|")
      }
      println()
    }
  }
}
