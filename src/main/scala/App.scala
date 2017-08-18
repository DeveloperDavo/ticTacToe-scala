object App {
  val X = 'x'
  val O = 'o'
  val E = ' '

  private var board = Array(
    Array(O, X, X),
    Array(O, O, X),
    Array(X, X, O))

  def main(args: Array[String]) {
    printBoard()
    println
    printTieOrWinner()
  }

  private def printTieOrWinner(): Unit = {
    val result = new Logic(board).determineWinner()
    if (E == result) {
      println("It's a tie!")
    } else {
      println("The winner is " + result)
    }
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
