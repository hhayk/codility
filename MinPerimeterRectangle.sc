/*
An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

  The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

  (1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

object Solution { def solution(n: Int): Int }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [1..1,000,000,000].
 */

object Solution {
  def solution(n: Int): Int = {
    for (i <- Math.sqrt(n).toInt to 0 by -1) {
      if (n % i == 0) return 2 * (i + n / i)
    }
    0
  }
}

Solution.solution(30)
