package Base;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillMatrix(matrix,0,1);
        return matrix;
    }
    public void fillMatrix(int[][] matrix,int index,int start){
        if(index>(matrix.length-1)/2){
            return ;
        }
        else if(index == matrix.length - index - 1){
            matrix[index][index] = start;
        }else{
            //第index行
            for(int i = index ; i < matrix.length - index - 1;i++){
                matrix[index][i] = start;
                start++;
            }
            //第matrix.length - 1 - index列
            for(int i = index ; i < matrix.length - index - 1;i++){
                matrix[i][matrix.length - 1 - index] = start;
                start++;
            }
            //第matrix.length - 1 - index行
            for(int i = matrix.length - index -1 ; i > index ;i--){
                matrix[matrix.length - index - 1][i] = start;
                start++;
            }
            //第index列
            for(int i = matrix.length - index -1 ; i > index ;i--){
                matrix[i][index] = start;
                start++;
            }
            fillMatrix(matrix,index + 1,start);
        }
    }
    public static void printMatrix(int[][] matrix){
        for(int[] i : matrix){
            for(int j : i){
                System.out.print(j+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        printMatrix(spiralMatrixII.generateMatrix(2));
    }
}
