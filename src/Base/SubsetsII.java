package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> lists;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lists = new ArrayList<>();
        int index = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        recursionSubset(list,nums,index);
        return lists;
    }
    public void recursionSubset(List<Integer> list,int[] nums, int index){
        if(index==nums.length){
            List<Integer> tempList = new ArrayList<>(list);
            lists.add(tempList);
            return;
        }else{
            int i = index + 1;
            while(i<nums.length&&nums[i]==nums[index]){
                i++;
            }
            for(int j = index;j<i ; j++){
                list.add(nums[index]);
                recursionSubset(list,nums,i);
            }
            List<Integer> removeList = new ArrayList<>();
            removeList.add(nums[index]);
            list.removeAll(removeList);
            recursionSubset(list,nums,i);
        }
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] array = new int[]{};
        System.out.println(subsetsII.subsetsWithDup(array));
    }
}
