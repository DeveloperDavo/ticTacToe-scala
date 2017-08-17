object App {
  var board = Array(Array("x", "x", "o"),
    Array("x", " ", "x"),
    Array("o", "o", "o"))

  def main(args: Array[String]) {
    printBoard()
    println
    println("The winner is " + determineWinner)
  }

  private def determineWinner = {
    if (board(0)(0).equals(board(0)(1)) && board(0)(0).equals(board(0)(2))) {
      board(0)(0)
    } else if(board(1)(0).equals(board(1)(1)) && board(1)(0).equals(board(1)(2))) {
      board(1)(0)
    } else if(board(2)(0).equals(board(2)(1)) && board(2)(0).equals(board(2)(2))) {
      board(2)(0)
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
