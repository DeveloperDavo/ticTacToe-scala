import result._

class ResultFactory {

  def getResult(entry: Char): Result = {
    if (App.X == entry) {
      new WinnerIsXResult
    } else if (App.O == entry) {
      new WinnerIsOResult
    } else {
      throw new IllegalArgumentException("Unsupported Entry")
    }
  }

}
