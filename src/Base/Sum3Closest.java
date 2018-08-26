package Base;

import java.util.Arrays;

/**
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class Sum3Closest {
    /**
     * @ error 复杂方法o(n^3)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int target_cloest = 99999999;
        int true_number = 0;
        //Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                for(int x = j + 1;x<nums.length;x++){
                    if(Math.abs(target-nums[i]-nums[j]-nums[x])<target_cloest){
                        target_cloest = Math.abs(target-nums[i]-nums[j]-nums[x]);
                        true_number = nums[i]+nums[j]+nums[x];
                    }
                }
            }
        }
        return true_number;
    }
    /**
     * 算法优化 O(N^2)
     */
    public int threeSumClosest1(int[] num, int target) {
            int result = num[0] + num[1] + num[num.length - 1];
            Arrays.sort(num);
            for (int i = 0; i < num.length - 2; i++) {
                int start = i + 1, end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
            return result;
        }
}
