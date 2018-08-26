package Base;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    returnArray[0] = i;
                    returnArray[1] = j;
                    return returnArray;
                }
            }
        }
        return null;
    }
}
