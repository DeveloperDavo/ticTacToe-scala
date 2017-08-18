import App.{E, O, X}
import result._

class Logic(board: Array[Array[Char]]) {
  def determineWinner(): Result = {

    val middleEntry = board(1)(1)
    if (isWinningDiagonal(middleEntry)) getResult(middleEntry)

    for (i <- board.indices) {
      val firstEntryInRow = board(i)(0)
      val firstEntryInColumn = board(0)(i)

      if (isWinningRow(firstEntryInRow, i)) {
        return getResult(firstEntryInRow)
      } else if (isWinningColumn(firstEntryInColumn, i)) {
        return getResult(firstEntryInColumn)
      }
    }

    if (isStillGoing) {
      return new NoResult
    }
    new TieResult

  }

  private def isStillGoing: Boolean = {
    for (i <- board.indices) {
      return board(i) contains E
    }
    false
  }



  private def getResult(entry: Char): Result = {
    if (X == entry) {
      new WinnerIsXResult
    } else {
      new WinnerIsOResult
    }
  }

  private def isWinningColumn(firstEntry: Char, column: Int): Boolean = {
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

  private def isWinningRow(firstEntry: Char, row: Int): Boolean = {
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

  private def isWinningDiagonal(middleEntry: Char): Boolean = {
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
