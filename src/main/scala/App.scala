object App {
  private val X = "x"
  private val O = "o"
  private val EMPTY = " "

  private var board = Array(Array(X, X, O),
    Array(X, EMPTY, X),
    Array(O, O, O))

  def main(args: Array[String]) {
    printBoard()
    printWinner()
  }

  private def printWinner() {
    var winner = ""
    for (row <- board.indices) {
      if ((board(row) contains X) || (board(row) contains O)) {
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
