package Base;

public class RotateImage {
    public void rotate(int[][] matrix) {
        rotateSubMatrix(matrix,0);
    }
    public void rotateSubMatrix(int[][] matrix,int index) {
        if (index > (matrix.length / 2 - 1)) {
            return;
        } else {
            int[] tempArray = new int[matrix.length];
            //第index行
            for(int i = index;i<matrix.length-index-1;i++){
                tempArray[i] = matrix[i][matrix.length - index - 1];
                matrix[i][matrix.length - index - 1] = matrix[index][i];
            }

            //第matrix.length-index-1列
            for(int i = index;i<matrix.length-index-1;i++){
                int temp = tempArray[i];
                tempArray[i] = matrix[matrix.length - index - 1][matrix.length - 1 - i];
                matrix[matrix.length - index - 1][matrix.length - i - 1] = temp;
            }

            //第matrix.length-index-1行
            for(int i = matrix.length - index - 1 ; i>index;i--){
                int temp = tempArray[matrix.length - 1  - i];
                tempArray[matrix.length - 1  - i] = matrix[i][index];
                matrix[i][index] = temp;
            }

            //第index列
            for(int i = index ; i<matrix.length -index-1;i++){
                matrix[index][i] = tempArray[i];
            }

            rotateSubMatrix(matrix,index + 1);
        }
    }
    public void printMatrix(int[][] martix){
        for(int[] i : martix){
            for (int j : i){
                System.out.print(j+",");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
    public void printArray(int[] martix){
        for(int i : martix){
            System.out.print(i+",");
        }
        System.out.println("\n---------");
    }
    public static void main(String[] args) {
        int[][] testMatrix = new int[][] {
                {1,2},{3,4}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(testMatrix);
        rotateImage.printMatrix(testMatrix);
    }
}
