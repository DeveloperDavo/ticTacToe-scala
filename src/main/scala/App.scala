object App {
  var board = Array(Array("x", " ", "o"),
    Array("x", "x", " "),
    Array(" ", "o", "o"))

  def main(args: Array[String]) {
    printBoard()
  }

  private def printBoard(): Unit = {
    board.foreach { boardRow =>
      printRow(boardRow)
    }
  }

  private def printRow(boardRow: Array[String]): Unit = {
    print("|")
    boardRow.foreach { boardElem =>
      printEntry(boardElem)
    }
    println()
  }

  private def printEntry(boardElem: String): Unit = {
    print(boardElem + "|")
  }
}
