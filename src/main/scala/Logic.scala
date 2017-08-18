import App.{O, X}
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


}
