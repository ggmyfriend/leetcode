package Base;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n==0){
            return 0;
        }
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2;i<=n;i++){
            int sum = 0;
            for(int j = 0;j<i;j++){
                sum += nums[j]*nums[i-j-1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(4));
    }
}
