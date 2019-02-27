package Base;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==1)
            matrix[0][0] =0;
        else
            matrix[0][0]=1;
        for(int i = 1;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]==1)
                matrix[0][i] = 0;
            else{
                matrix[0][i] = matrix[0][i-1];
            }
        }
        for(int i = 1;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1)
                matrix[i][0] = 0;
            else{
                matrix[i][0] = matrix[i-1][0];
            }
        }
        for(int i = 1;i<obstacleGrid.length;i++){
            for(int j = 1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j] == 1){
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePaths = new UniquePathsII();
        int[][] matrix = new int[][]{
                {0,0,0},
                {0,0,1},
                {0,1,0}
        };
        System.out.println(uniquePaths.uniquePathsWithObstacles(matrix));
    }
}
