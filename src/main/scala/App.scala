object App {
  private val X = "x"
  private val O = "o"
  private val E = " "

  private var board = Array(
    Array(O, O, O),
    Array(X, X, O),
    Array(O, X, X))

  def main(args: Array[String]) {
    printBoard()
    determineWinner()
  }

  private def determineWinner() {
    var winner = ""
    var playing = false
    winner = determineIfDiagonal()
    for (i <- board.indices) {
      if ((board(i) contains X) || (board(i) contains O)) {
        if (board(i)(0).equals(board(i)(1)) && board(i)(0).equals(board(i)(2))) {
          winner = board(i)(0)
        } else if (board(0)(i).equals(board(1)(i)) && board(0)(i).equals(board(2)(i))) {
          winner = board(0)(i)
        }
      }
      if (board(i) contains E) {
        playing = true
      }
    }
    printTieOrWinner(winner, playing)
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


  private def printTieOrWinner(winner: String, playing: Boolean): Unit = {
    if (!playing && winner.isEmpty) {
      println
      println("It's a tie!")
    }
    else if (!winner.isEmpty) {
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
