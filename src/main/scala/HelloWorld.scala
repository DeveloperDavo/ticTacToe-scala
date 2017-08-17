object HelloWorld {
  def main(args: Array[String]) {
    var board = Array("x", " ", "o")
    print("|")
    board.foreach { boardElem =>
      print(boardElem + "|")
    }
  }
}
