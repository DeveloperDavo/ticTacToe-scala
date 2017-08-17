object App {
  var board = Array(Array("x", "x", "o"),
    Array("x", " ", "x"),
    Array("o", "o", "o"))

  def main(args: Array[String]) {
    printBoard()
    printWinner()
  }

  private def printWinner() {
    var winner = ""
    for (row <- board.indices) {
      if ((board(row) contains "x") || (board(row) contains "o")) {
        if (board(row)(0).equals(board(row)(1)) && board(row)(0).equals(board(row)(2))) {
          winner = board(row)(0)
        }
      }
    }
    println()
    println("The winner is " + winner)
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
    println
  }

  private def printEntry(boardElem: String): Unit = {
    print(boardElem + "|")
  }
}
