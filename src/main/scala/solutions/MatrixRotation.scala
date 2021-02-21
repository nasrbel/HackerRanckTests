package solutions

object MatrixRotation {

  /**
   * You are given a 2D matrix, a, of dimension MxN and a positive integer R.
   * You have to rotate the matrix R times and print the resultant matrix.
   * Rotation should be in anti-clockwise direction.
   *
   * Rotation of a 4x5 matrix is represented by the
   * following figure. Note that in one rotation, you have
   * to shift elements by one step only (refer sample tests for more clarity).
   *
   *
   */
  /**
   * How I will solve the problem, myb idea is :
   *
   *
   * divide the matrix into 4 objects :
   * Object 1 : H1: the direction is horizontal and the sense is from right to left (i,j) <- (i,j-1)
   * Object 2 : H2: the direction is horizontal and the sense is from left  to right  (i,j) (i,j+1)
   * Object 3 : V1: the direction is vertical and the sense is from down   to up    (i,j) <- (i-1,j)
   * Object 4 : V2: the direction is vertical and the sense is from up   to down  (i,j) <- (i+1,j)
   * H1: all lines with index i [0 to N/2]
   * H2: all lines with index i [N/2 + 1 to N]
   * V1: all cols with index j [M/2 + 1 to M]
   * V2: all cols with index j [0 to M/2]
   * I will take into considerations two points: 1) if N  or M is odd or even
   *                                             2) separate some index (i,j) that can be in both directions H and V
   */



}
