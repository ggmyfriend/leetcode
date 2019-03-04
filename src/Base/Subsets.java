package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        calculateSubsets(new ArrayList<>(),nums,0);
        return lists;
    }
    public void calculateSubsets(List<Integer> list,int[] nums,int k){
        if(k==nums.length-1){
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(nums[k]);
            lists.add(list1);
            List<Integer> list2 = new ArrayList<>(list);
            lists.add(list2);
        }else{
            list.add(nums[k]);
            calculateSubsets(list,nums,k+1);
            list.remove(new Integer(nums[k]));
            calculateSubsets(list,nums,k+1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2}));
    }
}
