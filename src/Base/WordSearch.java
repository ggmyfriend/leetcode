package Base;

public class WordSearch {
    public static boolean isFind;
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return true;
        }

        isFind = false;
        char c = word.charAt(0);
        word = word.substring(1);
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==c){
                    if(word.length()==0){
                        return true;
                    }
                    board[i][j] = 0;
                    if(i-1 >= 0){
                        findExist(board,word,i-1,j);
                    }
                    if(i+1<=board.length-1){
                        findExist(board,word,i+1,j);
                    }

                    if(j-1 >= 0){
                        findExist(board,word,i,j-1);
                    }
                    if(j+1<=board[0].length-1){
                        findExist(board,word,i,j+1);
                    }
                    board[i][j]=c;
                }
            }
        }
        return isFind;
    }
    public void findExist(char[][] board,String word,int row,int column){
        if(word.equals("")){
            isFind = true;
            return;
        }else if(isFind==false) {
            if (word.charAt(0) == board[row][column]) {
                char c = word.charAt(0);
                board[row][column] = 0;
                if(row-1 >= 0){
                    findExist(board,word.substring(1),row-1,column);
                }
                if(row+1<=board.length-1){
                    findExist(board,word.substring(1),row+1,column);
                }
                if(column-1 >= 0){
                    findExist(board,word.substring(1),row,column-1);
                }
                if(column+1<=board[0].length-1){
                    findExist(board,word.substring(1),row,column+1);
                }
                board[row][column] = c;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{
                {'A'}
        };
        System.out.println(wordSearch.exist(board,"A"));
    }
}
