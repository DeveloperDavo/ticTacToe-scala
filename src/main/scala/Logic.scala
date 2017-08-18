import result._

class Logic(board: Array[Array[Char]]) {
  def determineWinner(): Result = {
    val factory = new ResultFactory

    val middleEntry = board(1)(1)
    if (isWinningDiagonal(middleEntry)) factory.getResult(middleEntry)

    for (i <- board.indices) {
      val firstEntryInRow = board(i)(0)
      val firstEntryInColumn = board(0)(i)

      if (isWinningRow(firstEntryInRow, i)) {
        return factory.getResult(firstEntryInRow)
      } else if (isWinningColumn(firstEntryInColumn, i)) {
        return factory.getResult(firstEntryInColumn)
      }
    }

    if (isStillGoing) {
      return factory.getResult(App.E)
    }
    new TieResult

  }

  private def isStillGoing: Boolean = {
    for (i <- board.indices) {
      if (board(i) contains App.E) {
        return true
      }
    }
    false
  }

  private def isWinningColumn(firstEntry: Char, column: Int): Boolean = {
    if (App.E == firstEntry) {
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
    if (App.E == firstEntry) {
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
    if (middleEntry == App.E) {
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
