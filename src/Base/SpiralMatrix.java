package Base;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length>0) {
            spiralOder(matrix, 0, list);
        }
        return list;
    }
    public void spiralOder(int[][] matrix,int index,List<Integer> list){
        if(index>((matrix.length-1)/2) || index > ((matrix[0].length-1)/2)){
            return ;
        }
        else if(index == (matrix[0].length - index - 1)){
            for(int i = index ; i < matrix.length - index;i++){
                list.add(matrix[i][index]);
            }
        }
        else if(index  == (matrix.length - index - 1)){
            for(int i = index ; i < matrix[0].length - index;i++){
                list.add(matrix[index][i]);
            }
        }
        else{
            //第index行
            for(int i = index;i<matrix[0].length - index - 1 ; i++){
                list.add(matrix[index][i]);
            }
            //第matrix[0].length - 1 - index 列
            for(int i = index;i<matrix.length - index - 1  ; i++){
                list.add(matrix[i][matrix[0].length - 1 -index]);
            }
            //第matrix.length - 1 -index 行
            for(int i = matrix[0].length - index - 1 ;i>index;i--){
                list.add(matrix[matrix.length - 1 -index][i]);
            }
            //第index列
            for(int i = matrix.length - index - 1 ;i>index;i--){
                list.add(matrix[i][index]);
            }
            spiralOder(matrix,index+1,list);
        }
    }

    public static void main(String[] args) {
        int [][] martix = new int[][]{
                {1,2,3,4,5,6,7,8,9,10},
                {11,12,13,14,15,16,17,18,19,20}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(martix));
    }
}
