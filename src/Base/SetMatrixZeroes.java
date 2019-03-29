package Base;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return;
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        Arrays.fill(row,1);
        Arrays.fill(column,1);
        for(int i = 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i] = 0;
                    column[j] = 0;
                }
            }
        }
        for(int i = 0;i<row.length;i++){
            if(row[i]==0){
                int[] temp = new int[matrix[0].length];
                Arrays.fill(temp,0);
                matrix[i] = temp;
            }
        }
        for(int i = 0;i<column.length;i++){
            if(column[i]==0){
                for(int j=0;j<row.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
    //使用第一行和第一列记录所有的状态，不再额外生成空间
    public void setZeroesLessSpace(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,2,1},
                {0,4,5,2}
        };
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroesLessSpace(matrix);
    }
}
