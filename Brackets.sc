/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

  S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
  For example, the string "{[()()]}" is properly nested but "([)()]" is not.

  Write a function:

object Solution { def solution(s: String): Int }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/

object Solution {
  def solution(s: String): Int = {
    if (s.length % 2 > 0) return 0

    val pat = "{}[]()"
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

Solution.solution("{[()()]}")
Solution.solution("([)()]")
Solution.solution("{{{{")
Solution.solution(")(")