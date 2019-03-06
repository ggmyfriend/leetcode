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
        int pre = 0,las=nums.length-1;
        int index = -1;
        while (pre<=las){
            int middle = (pre + las)/2;
            if(nums[middle] == target){
                index = middle;
                break;
            }
            if(target == nums[pre]){
                index = pre;
                break;
            }
            if(target == nums[las]){
                index = las;
                break;
            }
            if(nums[pre]<nums[las]){
                if(target<nums[middle]){
                    las = middle - 1;
                }else{
                    pre = middle + 1;
                }
            }else{
                if(target<nums[middle]) {
                    if(nums[pre]<target){
                        las = middle - 1;
                    }else if(nums[middle]<nums[las]){
                        las = middle - 1;
                    }else if(target<nums[las]&&nums[pre]<nums[middle]){
                        pre = middle + 1;
                    }else{
                        break;
                    }
                }else{
                    if(nums[pre]<nums[middle]){
                        pre = middle + 1;
                    }else if(nums[middle]<nums[las]&&nums[pre]<target){
                        las = middle - 1;
                    }else if(nums[las]>target){
                        pre = middle + 1;
                    }else{
                        break;
                    }
                }
            }
        }
        return index;
    }
}
