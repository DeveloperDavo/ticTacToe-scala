object App {
  private val X = "x"
  private val O = "o"
  private val E = " "

  private var board = Array(
    Array(X, X, O),
    Array(O, O, X),
    Array(X, X, O))

  def main(args: Array[String]) {
    printBoard()
    println
    printTieOrWinner()
  }

  private def printTieOrWinner(): Unit = {
    val result = determineWinner()
    if (result.equals(E)) {
      println("It's a tie!")
    } else {
      println("The winner is " + result)
    }
  }

  private def determineWinner(): String = {
    if (determineIfDiagonalIsFilled()) return board(1)(1)
    for (i <- board.indices) {
      if ((board(i) contains X) || (board(i) contains O)) {
        if (isWinningRow(i)) {
          return board(i)(0)
        } else if (isWinningColumn(i)) {
          return board(0)(i)
        }
      }
    }
    E
  }

  private def isWinningColumn(i: Int) = {
    board(0)(i).equals(board(1)(i)) && board(0)(i).equals(board(2)(i))
  }

  private def isWinningRow(i: Int) = {
    board(i)(0).equals(board(i)(1)) && board(i)(0).equals(board(i)(2))
  }

  private def determineIfDiagonalIsFilled(): Boolean = {
    val middleEntry = board(1)(1)
    if (middleEntry.equals(X) || middleEntry.equals(O)) {
      if (board(0)(0).equals(middleEntry) && middleEntry.equals(board(2)(2))) {
        return true
      } else if (board(0)(2).equals(middleEntry) && middleEntry.equals(board(2)(0))) {
        return true
      }
    }
    false
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
