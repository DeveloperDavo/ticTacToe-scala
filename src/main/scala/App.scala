object App {
  private val X = "x"
  private val O = "o"
  private val E = " "

  private var board = Array(
    Array(O, O, X),
    Array(X, X, X),
    Array(O, O, E))

  def main(args: Array[String]) {
    printBoard()
    println

    val result = determineWinner()
    if (result.equals(X) || result.equals(O)) {
      println("The winner is " + result)
    } else {
      println("It's a tie!")
    }
  }

  private def determineWinner(): String = {
    var winner = ""
    winner = determineIfDiagonal()
    for (i <- board.indices) {
      if ((board(i) contains X) || (board(i) contains O)) {
        if (isWinningRow(i)) {
          winner = board(i)(0)
        } else if (isWinningColumn(i)) {
          winner = board(0)(i)
        }
      }
    }
    winner
  }

  private def isWinningColumn(i: Int) = {
    board(0)(i).equals(board(1)(i)) && board(0)(i).equals(board(2)(i))
  }

  private def isWinningRow(i: Int) = {
    board(i)(0).equals(board(i)(1)) && board(i)(0).equals(board(i)(2))
  }

  private def determineIfDiagonal(): String = {
    var winner = ""
    val middleEntry = board(1)(1)
    if (middleEntry.equals(X) || middleEntry.equals(O)) {
      if (board(0)(0).equals(middleEntry) && middleEntry.equals(board(2)(2))) {
        winner = middleEntry
      } else if (board(0)(2).equals(middleEntry) && middleEntry.equals(board(2)(0))) {
        winner = middleEntry
      }
    }
    winner
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
