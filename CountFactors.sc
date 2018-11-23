/*
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

  For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

  Write a function:

object Solution { def solution(n: Int): Int }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

  N is an integer within the range [1..2,147,483,647].
 */

object Solution {
  def solution(n: Int): Int = {
    def rec(cand: Long, sum: Int): Int = {
      if (cand * cand > n) sum
      else if (cand * cand == n) sum + 1
      else rec(cand + 1, sum + (if (n % cand == 0) 2 else 0))
    }

    rec(1, 0)
  }
}

Solution.solution(24)
Solution.solution(Int.MaxValue)