package models

case class Navigate(remainingGeology: List[GeologyRow], x: Int, y: Int, trees: Int) {
  def nextRow(moveX: Int, moveY: Int): Int = {
    if (moveX > remainingGeology.head.array.length || moveY > remainingGeology.length) {
      trees
    } else {
      move(moveX, moveY).nextRow(moveX, moveY)
    }
  }

  def move(moveX: Int, moveY: Int): Navigate = {
    remainingGeology.drop(moveY).head.array(x + moveX) match {
      case "#" => Navigate(remainingGeology.drop(moveY), x + moveX, y + moveY, trees + 1)
      case _ => Navigate(remainingGeology.drop(moveY), x + moveX, y + moveY, trees)
    }
  }
}
