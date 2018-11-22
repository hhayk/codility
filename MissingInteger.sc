//This is a demo task.
//
//  Write a function:
//
//object Solution { def solution(a: Array[Int]): Int }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//  For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//Given A = [1, 2, 3], the function should return 4.
//
//Given A = [−1, −3], the function should return 1.
//
//Write an efficient algorithm for the following assumptions:
//
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000].

object Solution {
  def solution(a: Array[Int]): Int = {
    val s = scala.collection.immutable.HashSet() ++ a
    var i = 1
    while (s.contains(i)) i = i + 1
    i
  }
}

Solution.solution(Array(1, 3, 6, 4, 1, 2))
Solution.solution(Array(1, 2, 3))
Solution.solution(Array(-1, -3))