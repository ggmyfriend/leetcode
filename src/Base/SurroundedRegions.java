package Base;

import javax.print.DocFlavor;

public class SurroundedRegions {
    int[][] matrix ;
    public void solve(Character[][] board) {
        if (board.length==0){
            return;
        }
        matrix = new int[board.length][];
        for(int i = 0;i<board.length;i++){
            matrix[i] = new int[board[0].length];
        }
        for(int i = 0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                matrix[0][i]=1;
                recurFind(board,0,i);
            }
        }for(int i = 0;i<board.length;i++){
            if(board[i][board[0].length-1]=='O'){
                matrix[i][board[0].length-1]=1;
                recurFind(board,i,board[0].length-1);
            }
        }for(int i = 0;i<board[0].length;i++){
            if(board[board.length-1][i]=='O'){
                matrix[board.length-1][i]=1;
                recurFind(board,board.length-1,i);
            }
        }for(int i = 0;i<board.length;i++){
            if(board[i][0]=='O'){
                matrix[i][0]=1;
                recurFind(board,i,0);
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++) {
                if(matrix[i][j]==1){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
    public void recurFind(Character[][] board,int row,int column){
        if(row-1>0){
            if(board[row-1][column]=='O'&&matrix[row-1][column]==0){
                matrix[row-1][column]=1;
                recurFind(board,row-1,column);
            }
        }
        if(row+1<board.length-1){
            if(board[row+1][column]=='O'&&matrix[row+1][column]==0){
                matrix[row+1][column]=1;
                recurFind(board,row+1,column);
            }
        }
        if(column-1>0){
            if(board[row][column-1]=='O'&&matrix[row][column-1]==0){
                matrix[row][column-1]=1;
                recurFind(board,row,column-1);
            }
        }
        if(column+1<board[0].length-1){
            if(board[row][column+1]=='O'&&matrix[row][column+1]==0){
                matrix[row][column+1]=1;
                recurFind(board,row,column+1);
            }
        }
    }
    public static void main(String[] args) {
        Character[][] matrixs = new Character[][]{
                {'X'},{'O'},{'O'},{'X'},
        };
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(matrixs);
        CommonUtils.<Character>printMatrix(matrixs);
    }
}
