package Base;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/
/**
 * @author 管可发
 * @date 2018/8/25 16:12
 */
public class SearchInRotateSortedArray {
    public int search(int[] nums, int target) {
            int i = 0,j=nums.length-1   ;
            while(i<=j){
                int mid = (i+j)/2;
                if(nums[mid]==target)
                    return mid;
                if(nums[i]>nums[j]){
                    if(nums[mid]<nums[j]){
                        if(target<nums[j])
                            i = mid;
                        else
                            j = mid;
                    }else{
                        if(target>nums[i])
                            j = mid;
                        else
                            i = mid;
                    }
                }
                if(nums[i]<nums[j]){
                    if(target>nums[mid])
                        i = mid;
                    else
                        j = mid;
                }
            }
            return -1;
    }
}
