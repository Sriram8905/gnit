object NthElementUsingMerge extends App {

  // recursive merge of 2 sorted lists
  def merge(lhs: List[Int], rhs: List[Int]): List[Int] =
    (lhs, rhs) match {
      case(lhs, Nil) => lhs
      case(Nil, rhs) => rhs
      case(lhsHead :: lhsTail, rhsHead :: rhsTail) =>
        if (lhsHead < rhsHead) lhsHead::merge(lhsTail, rhs)
        else rhsHead :: merge(lhs, rhsTail)
    }

  def mergeSort(list: List[Int]): List[Int] = {
    val n = list.length / 2
    if (n == 0)
      list
         // i.e. if list is empty or single value, no sorting needed
    else {
      val (lhs, rhs) = list.splitAt(n)
      merge(mergeSort(lhs), mergeSort(rhs))
    }
  }
/* we have written below pattern matching just to avoid array index out of the bounds exception
* if some one has give index out of the range also it will not fail*/
  def nthElement(list:List[Int],k:Int):Option[Int]=
    k match {
      case k if k < list.size => Some(list(k))
      case _ => None
    }

  println(mergeSort(List(33,44,22,-10,99)))
  println(nthElement(mergeSort(List(33,44,22,-10,99)),200).getOrElse());

}