object App {
  private val X = "x"
  private val O = "o"
  private val E = " "

  private var board = Array(
    Array(X, O, X),
    Array(E, X, E),
    Array(O, O, E))

  def main(args: Array[String]) {
    printBoard()
    printWinner()
  }

  private def printWinner() {
    var winner = ""
    for (i <- board.indices) {
      val middleEntry = board(1)(1)
      if (middleEntry.equals(X) || middleEntry.equals(O)) {
        if (board(0)(0).equals(middleEntry) && middleEntry.equals(board(2)(2))) {
          winner = middleEntry
        } else if (board(0)(2).equals(middleEntry) && middleEntry.equals(board(2)(0))) {
          winner = middleEntry
        }
      }
      if ((board(i) contains X) || (board(i) contains O)) {
        if (board(i)(0).equals(board(i)(1)) && board(i)(0).equals(board(i)(2))) {
          winner = board(i)(0)
        } else if (board(0)(i).equals(board(1)(i)) && board(0)(i).equals(board(2)(i))) {
          winner = board(0)(i)
        }
      }
    }
    if (!winner.isEmpty) {
      println
      println("The winner is " + winner)
    }
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
