package Base;

import NewStart.RemoveNthNode;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int length=1;
        int pre = nums[0];
        int index = 1;
        boolean isEquals = false;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]==pre&&isEquals==false){
                isEquals = true;
                length++;
                nums[index] = pre;
                index++;
            }
            if(nums[i]!=pre){
                isEquals = false;
                length++;
                pre = nums[i];
                nums[index] = pre;
                index++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesfromSortedArrayII removeNthNode = new RemoveDuplicatesfromSortedArrayII();
        System.out.println(removeNthNode.removeDuplicates(nums));
        CommonUtils.printArrays(nums);
    }
}
