package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guankefa
 * @description of the problem:
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */

public class SpiralMatrix {
    public static List<Integer> Solution(int[][] matrix){
        ArrayList<Integer> array = new ArrayList<Integer>();
        if (matrix.length==0){
            return array;
        }
        int row,columns;
        row = matrix.length;
        columns = matrix[0].length;
        int temp_times;
        if(row>columns){
            temp_times = columns;
        }else {
            temp_times = row;
        }
        int times;
        if(temp_times%2==1)
            times = (temp_times/2) + 1;
        else
            times = (temp_times/2);
        for(int i = 0;i < times;i++) {
            for (int j = i; j <= matrix[i].length - 1 - i; j++) {
                array.add(matrix[i][j]);
            }
            if( matrix.length-1-i > i) {
                for (int j = i + 1; j <= matrix.length - 1 - i; j++) {
                    array.add(matrix[j][matrix[i].length - 1 - i]);
                }
                if (matrix[i].length - 1 - i > i) {
                    for (int j = matrix[i].length - 2 - i; j >= i; j--) {
                        array.add(matrix[matrix.length - 1 - i][j]);
                    }
                    for (int j = matrix.length - 2 - i; j > i; j--) {
                        array.add(matrix[j][i]);
                    }
                }
            }
        }
        return array;
    }
    //leetcode提供的方法
    public static List<Integer> Solution2(int[][] matrix){
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        //相比自己写的 leetcode提供的代码提供了更加清晰的思路，使用while会比for更加容易理解
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
    public static void main2(String []args){
        int [][] matrix = {{1,6,10,13}};
        //int [][] matrix = {{1, 2, 3},{4,5,6 },{7,8,9 }};
        System.out.print(Solution(matrix));
    }
}
