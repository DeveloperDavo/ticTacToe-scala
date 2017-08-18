import App.{O, X, E}
import result.{Result, TieResult, WinnerIsOResult, WinnerIsXResult}

class Logic(board: Array[Array[Char]]) {
  def determineWinner(): Result = {
    if (determineIfDiagonalIsFilled()) return getResult(board(1)(1))
    for (i <- board.indices) {
      if ((board(i) contains X) || (board(i) contains O)) {
        if (isWinningRow(i)) {
          return getResult(board(i)(0))
        } else if (isWinningColumn(i)) {
          return getResult(board(0)(i))
        }
      }
    }
    new TieResult
  }

  private def getResult(entry: Char): Result = {
    if (X == entry) {
      new WinnerIsXResult
    } else {
      new WinnerIsOResult
    }
  }

  private def isWinningColumn(column: Int): Boolean = {
    val firstEntry = board(0)(column)

    if (E == firstEntry) {
      return false
    }

    for (i <- 1 until board.length) {
      if (firstEntry != board(i)(column)) {
        return false
      }
    }
    true
  }

  private def isWinningRow(row: Int): Boolean = {
    val firstEntry = board(row)(0)

    if (E == firstEntry) {
      return false
    }

    for (i <- 1 until board.length) {
      if (firstEntry != board(row)(i)) {
        return false
      }
    }
    true
  }

  private def determineIfDiagonalIsFilled(): Boolean = {
    val middleEntry = board(1)(1)
    if (middleEntry == E) {
      false
    } else {
      checkBothDiagonals(middleEntry)
    }
  }


  private def checkBothDiagonals(middleEntry: Char): Boolean = {
    if (board(0)(0) == middleEntry && middleEntry == board(2)(2)) {
      return true
    } else if (board(0)(2) == middleEntry && middleEntry == board(2)(0)) {
      return true
    }
    false
  }
}
