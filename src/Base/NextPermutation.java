package Base;
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

/**
 * @author 管可发
 * @date 2018/8/25 15:09
 */
public class NextPermutation {
    //注意细节上的把控
    public static void nextPermutation(int [] nums){
        int temp=-1;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                temp = i - 1;
                break;
            }
        }
        if(temp == -1){
            reverse(nums,0);
            return ;
        }
        for(int i = temp+1;i<nums.length;i++) {
            if (nums[i] <= nums[temp]) {
                int middle = nums[temp];
                nums[temp] = nums[i - 1];
                nums[i - 1] = middle;
                reverse(nums, temp + 1);
                return;
            }
        }
        int middle = nums[temp];
        nums[temp] = nums[nums.length - 1];
        nums[nums.length - 1] = middle;
        reverse(nums, temp + 1);

    }
    //翻转数组
    private static  void reverse(int [] nums,int tpx){
        int x=tpx,y=nums.length-1;
        while(x<=y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
    //测试程序
    public static void main(String args[]){
        int[] nums = {1,2};
        nextPermutation(nums);
        for (int i: nums) {
            System.out.print(i+",");
        }
    }
}
