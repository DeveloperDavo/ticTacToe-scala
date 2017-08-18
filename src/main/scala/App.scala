object App {
  val X = 'x'
  val O = 'o'
  val E = ' '

  private var board = Array(
    Array(X, E, O),
    Array(X, E, O),
    Array(X, E, E))

  def main(args: Array[String]) {
    printBoard()
    println
    printTieOrWinner()
  }

  private def printTieOrWinner(): Unit = {
    val result = new Logic(board).determineWinner()
    println(result.getMessage)
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
