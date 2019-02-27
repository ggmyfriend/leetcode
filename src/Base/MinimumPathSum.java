package Base;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        matrix[0][0] = grid[0][0];
        for(int i = 1 ;i < grid.length ; i++){
            matrix[i][0] = matrix[i-1][0] + grid[i][0];
        }
        for(int i = 1 ;i < grid[0].length ; i++){
            matrix[0][i] = matrix[0][i-1] + grid[0][i];
        }
        for(int i = 1 ;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                matrix[i][j] = Math.min(matrix[i-1][j],matrix[i][j-1]) + grid[i][j];
            }
        }
        return matrix[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] matrix = new int[][]{
                {1,3,1},
                {1,5,1}
        };
        System.out.println(minimumPathSum.minPathSum(matrix));
    }
}
