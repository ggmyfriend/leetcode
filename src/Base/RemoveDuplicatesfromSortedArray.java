package Base;

/**
 Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<1)
            return 0;
        int diffNumber = 1;
        int diffN = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=diffN){
                diffNumber++;
                diffN = nums[i];
            }
        }
        return diffNumber;
    }
}
