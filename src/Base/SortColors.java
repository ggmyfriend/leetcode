package Base;

public class SortColors {
    public void sortColors(int[] nums) {
        int index1 = nums.length-1,index2=nums.length-1;
        int i = 0;
        while(i<=index1){
            if(nums[i]==0){
                i++;
                continue;
            }
            if(i!=index1) {
                if (nums[i] == 2) {
                    swap(nums,index1,index2);
                    swap(nums,i,index2);
                    index1--;
                    index2--;
                }
                if(nums[i]==1){
                    swap(nums,index1,i);
                    index1--;
                }
            }else{
                if(nums[i]==1){
                    i++;
                    continue;
                }else{
                    swap(nums,index1,index2);
                    index1--;
                    index2--;
                }
            }
        }
    }
    private void swap(int[] nums,int pre,int las){
        int temp = nums[pre];
        nums[pre] = nums[las];
        nums[las] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        CommonUtils.printArrays(nums);
    }
}
