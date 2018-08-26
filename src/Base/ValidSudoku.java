package Base;
/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author 管可发
 * @date 2018/8/26 12:56
 */
public class ValidSudoku {
    public static  boolean isValidSudoku(char[][] board) {
        //验证每一竖排和横排
        List<Character> list= new ArrayList<>();
        for(int i = 0; i<9; i++){
            list.clear();
            for(int j = 0;j<9;j++){
                if(list.contains(board[i][j]) && board[i][j]!= '.'){
                    return false;
                }else{
                    list.add(board[i][j]);
                }
            }
            list.clear();
            for(int j = 0;j<9;j++){
                if(list.contains(board[j][i]) && board[j][i]!= '.'){
                    return false;
                }else{
                    list.add(board[j][i]);
                }
            }
        }
        //判断没3*3的方块
        for(int i = 0;i<9;i++){
            list.clear();
            for(int j = 0;j<9;j++){
                if(list.contains(board[(i/3)*3+j/3][j%3+(i%3)*3]) && board[(i/3)*3+j/3][j%3+(i%3)*3]!= '.'){
                    return false;
                }else{
                    list.add(board[(i/3)*3+j/3][j%3+(i%3)*3]);
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        char[][] example = new char[][]{{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(example));
        //char s = ''; //char不能为空
    }
}
