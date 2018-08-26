package Base;
/*
NAME:Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
 */
/**
 * @author 管可发
 * @date 2018/8/26 7:20
 */
public class FindFirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int tempx = 0,tempy = nums.length-1;
        while(tempx < tempy){
            int mid = (tempx+tempy)/2;
            if(nums[mid]!=target){
                if(target<nums[mid]){
                    tempy = mid-1;
                }else{
                    tempx = mid+1;
                }
            }else{
                int i = mid, j = mid;
                while(i>=0&&nums[i]==target){
                    if(nums[i]==target){
                        i--;
                    }
                }
                while(j<=nums.length-1&&nums[j]==target){
                    if(nums[j]==target){
                        j++;
                    }
                }
                return new int[]{i+1,j-1};
            }
        }
        if(tempx == tempy){
            int mid = (tempx+tempy)/2;
            if(nums[mid]==target) {
                return new int[]{mid,mid};
            }
        }

        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int[] nums = new int[]{5,7,7,8,8,10};
        for (int i:searchRange(nums,6)){
            System.out.print(i+" ");
        }
    }
}
