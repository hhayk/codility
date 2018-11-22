/*
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
  For example, string "(()(())())" is properly nested but string "())" isn't.

  Write a function:

object Solution { def solution(s: String): Int }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/


object Solution {
  def solution(s: String): Int = {
    if (s.length % 2 > 0) return 0

    val pat = "()"
    val sta = scala.collection.mutable.ArrayStack[Char]()

    for (c <- s) {
      val pi = pat indexOf c

      if (pi % 2 == 0) sta.push(c)
      else {
        val hi = pat indexOf sta.headOption.getOrElse(Int.MaxValue)
        if (pi - hi == 1) sta.pop()
      }
    }

    if (sta.isEmpty) 1 else 0
  }
}

Solution.solution("(()(())())")