package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<4){
            return lists;
        }
        for(int pre = 0;pre<=nums.length-4;){
            for(int las = nums.length-1;las > pre+2;) {
                int tempPre = pre + 1, tempLas = las - 1;
                int tempSum = nums[pre] + nums[las];
                while (tempPre < tempLas) {
                    if (target < tempSum + nums[tempLas] + nums[tempPre]) {
                        tempLas--;
                        while (tempLas>=0&&nums[tempLas + 1] == nums[tempLas]) {
                            tempLas--;
                        }
                    } else if (target > tempSum + nums[tempLas] + nums[tempPre]) {
                        tempPre++;
                        while (tempPre<nums.length&&nums[tempPre - 1] == nums[tempPre]) {
                            tempPre++;
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[pre]);
                        list.add(nums[tempPre]);
                        list.add(nums[tempLas]);
                        list.add(nums[las]);
                        lists.add(list);
                        tempLas--;
                        while (tempLas>=0&&nums[tempLas + 1] == nums[tempLas]) {
                            tempLas--;
                        }
                        tempPre++;
                        while (tempPre<nums.length&&nums[tempPre - 1] == nums[tempPre]) {
                            tempPre++;
                        }
                    }
                }
                //todo las--
                las--;
                while(las>pre+2&&(nums[las+1]==nums[las])){
                    las--;
                }
            }
            //todo pre++
            pre++;
            while(pre<nums.length-4&&(nums[pre-1]==nums[pre])){
                pre++;
            }
        }
        return lists;
    }
    //[-4,0,-4,2,2,2,-2,-2]
    //7
    public static void main(String[] args){
        Sum4 sum = new Sum4();
        System.out.println(sum.fourSum(new int[]{-4,0,-4,2,2,2,-2,-2},7));
    }
}
