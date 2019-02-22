package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> lists;
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0 ;i<nums.length;i++){
            array.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        permuteList(array,list);
        return lists;
    }
    public void permuteList(List<Integer> array,List<Integer> list){
        if(array.size()==0){
            List<Integer> result = new ArrayList<>(list);
            lists.add(result);
            return;
        }
        else{
            for(int i = 0;i<array.size();i++){
                list.add(array.get(i));
                int temp = array.remove(i);
                permuteList(array,list);
                list.remove(new Integer(temp));
                array.add(i,temp);
            }
        }
    }
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }
}
