package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if( c == 0 || c == r)
        1
      else
        pascal(c-1,r-1) + pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      val num: Int = 0
      def innerFun(list: List[Char], num: Int): Boolean = {
        if(list.isEmpty){
          if(num == 0)
            true
          else
            false
        }
        else if(list.head != '(' && list.head != ')')
          innerFun(list.tail, num)
        else if(list.head == ')' && (num == 0))
          false
        else if(list.head == '(')
          innerFun(list.tail, num+1)
        else
          innerFun(list.tail, num-1)
      }
      return innerFun(chars, num)
    }
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty ) 0
        else if (money == 0 ) 1
        else loop(money, coins.tail) + loop(money - coins.head, coins)
      }
      loop(money, coins)
    }
  }
