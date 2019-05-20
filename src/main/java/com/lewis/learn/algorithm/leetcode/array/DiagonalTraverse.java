package com.lewis.learn.algorithm.leetcode.array;

/**
 * @author minghzhang
 * @date 2019/05/19
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The total number of elements of the given matrix will not exceed 10,000.
 * <p>
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {

    public static void main(String[] args) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};
        int totalElementNumber = diagonalTraverse.getTotalElementNumber(matrix);
        System.out.println(totalElementNumber);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int totalElementNumber = getTotalElementNumber(matrix);
        int[] ret = new int[totalElementNumber];
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

            }
        }

        return ret;
    }

    private int getTotalElementNumber(int[][] matrix) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i].length;
        }
        return total;
    }
}
