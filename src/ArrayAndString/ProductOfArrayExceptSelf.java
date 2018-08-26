package ArrayAndString;
/**
 * @author guankefa
 * @description of the problem:
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductOfArrayExceptSelf {
    //基本思想，i前*i后
    public static int [] Solution(int[] nums){
        int [] buff = new int[nums.length];
        int [] buff1 = new int[nums.length];
        int product = 1;
        for(int i = 0 ; i < nums.length ; i++){
            buff[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            buff1[i] = product;
            product = product * nums[i];
        }

        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = buff[i]*buff1[i];
        }
        return nums;
    }
    //优化上面的方法,减少空间
    public static int[] Solution2(int[] nums){
        int [] buff = new int[nums.length];
        buff[0] = 1;
        for(int i = 1;i<nums.length;i++){
            buff[i] = nums[i-1] * buff[i-1];
        }
        int tempprod = 1;
        for(int i = nums.length - 1 ; i >= 0;i--){
            buff[i] = buff[i] * tempprod;
            tempprod = tempprod * nums[i];
        }
        return buff;
    }
    public static void printIntArray(int[] array){
        for(int i =0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void main1(String []args){
        int [] nums = {1,2,3,4};
        nums = Solution2(nums);
        for(int i =0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
