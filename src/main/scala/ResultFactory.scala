import result._

class ResultFactory {

  def getResult(entry: Char): Result = {
    if (App.X == entry) {
      new WinnerIsXResult
    } else if (App.O == entry) {
      new WinnerIsOResult
    } else if (App.E == entry) {
      new NoResult
    } else if (App.TIE == entry) {
      new TieResult
    } else {
      throw new IllegalArgumentException("Unsupported Entry: " + entry)
    }
  }

}
