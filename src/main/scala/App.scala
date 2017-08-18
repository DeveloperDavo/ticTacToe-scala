object App {
  val X = 'x'
  val O = 'o'
  val E = ' '
  val TIE = 't'

  def main(args: Array[String]) {
    val board1 = Array(
      Array(X, O, X),
      Array(X, E, O),
      Array(O, X, O))

    val board2 = Array(
      Array(X, O, X),
      Array(X, X, O),
      Array(O, X, O))

    printTurn(board1)
    printTurn(board2)
  }

  private def printTurn(board: Array[Array[Char]]): Unit = {
    printBoard(board)
    println
    printResult(board)
  }

  private def printResult(board: Array[Array[Char]]): Unit = {
    val result = new Logic(board).determineWinner()
    println(result.getMessage)
  }

  private def printBoard(board: Array[Array[Char]]): Unit = {
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
