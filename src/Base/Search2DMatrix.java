package Base;

import java.util.Arrays;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int top = 0,bottom = matrix.length-1;
        int middleRow = (top+bottom)/2;
        int left = 0,right = matrix[0].length - 1;
        int middleColumn = (left+right)/2;
        if(matrix[0][0]>target){
            return false;
        }
        if(matrix[matrix.length-1][matrix[0].length-1]<target){
            return false;
        }
        boolean isFind = false;
        while(!isFind&&(top<=bottom)){
            if(middleRow==matrix.length-1){
                isFind=true;
                continue;
            }
            else{
                if(matrix[middleRow][0]==target){
                    return true;
                }
                if((matrix[middleRow][0]<target)&&(matrix[middleRow+1][0]>target)){
                    isFind=true;
                    continue;
                }
                else{
                    if(matrix[middleRow][0]<target){
                        top = middleRow+1;
                        middleRow = (top+bottom)/2;
                    }else{
                        bottom = middleRow - 1;
                        middleRow = (top+bottom)/2;
                    }
                }
            }
        }
        while(left<=right){
           // System.out.println(matrix[middleRow][middleColumn]);
            if(matrix[middleRow][middleColumn]==target){
                return true;
            }
            else if(matrix[middleRow][middleColumn]<target){
                left = middleColumn+1;
                middleColumn = (left+right)/2;
            }else{
                right = middleColumn-1;
                middleColumn = (left+right)/2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,50}
        };
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix,11));
    }
}
