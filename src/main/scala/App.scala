object App {
  private val X = 'x'
  private val O = 'o'
  private val E = ' '

  private var board = Array(
    Array(X, X, X),
    Array(O, O, X),
    Array(X, O, O))

  def main(args: Array[String]) {
    printBoard()
    println
    printTieOrWinner()
  }

  private def printTieOrWinner(): Unit = {
    val result = determineWinner()
    if (E == result) {
      println("It's a tie!")
    } else {
      println("The winner is " + result)
    }
  }

  private def determineWinner(): Char = {
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
    board(0)(i) == board(1)(i) && board(0)(i) == board(2)(i)
  }

  private def isWinningRow(i: Int) = {
    board(i)(0) == board(i)(1) && board(i)(0) == board(i)(2)
  }

  private def determineIfDiagonalIsFilled(): Boolean = {
    val middleEntry = board(1)(1)
    if (X == middleEntry || middleEntry == O) {
      if (board(0)(0) == middleEntry && middleEntry == board(2)(2)) {
        return true
      } else if (board(0)(2) == middleEntry && middleEntry == board(2)(0)) {
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

  private def printRow(boardRow: Array[Char]): Unit = {
    print("|")
    boardRow.foreach { boardElem =>
      printEntry(boardElem)
    }
    println
  }

  private def printEntry(boardElem: Char): Unit = {
    print(boardElem + "|")
  }
}
