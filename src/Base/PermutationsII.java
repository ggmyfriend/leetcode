package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static List<List<Integer>> lists;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            for(int i = 0;i<array.size();){
                int temp = array.get(i);
                int tempIndex = i;
                while(tempIndex<array.size()&&temp == array.get(tempIndex)){
                    tempIndex++;
                }
                list.add(array.get(i));
                array.remove(i);
                permuteList(array,list);
                //需要注意删除元素的顺序
                list.remove(list.lastIndexOf(temp));
                array.add(i,temp);
                i = tempIndex;
            }
        }
    }
    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        System.out.println(permutations.permuteUnique(new int[]{2,2,1,1}));
    }
}
