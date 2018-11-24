/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

  A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
  For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 12
There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

  Write a function:

object Solution { def solution(a: Array[Int]): Int }

that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [0..1,000];
each element of array A is an integer within the range [1..1,000,000,000].
*/


object Solution {
  def solution(a: Array[Int]): Int = {
    val arr = a.sorted
    var sum = 0

    for (i <- 0 until arr.length - 2) {
      var left = i + 1
      var right = i + 2
      while (left < arr.length - 1) {
        println(left, right)
        if (right < arr.length && arr(i) + arr(left) > arr(right))
          right = right + 1
        else {
          sum = sum + right - left - 1
          left = left + 1
        }
      }
    }

    sum
  }
}

Solution.solution(Array(10, 2, 5, 1, 8, 12))