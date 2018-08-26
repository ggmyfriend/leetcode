package Base;

import java.util.*;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class Sum3 {
    /**
     * @error 会有重复
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer,List> hashMap = new HashMap<>();
        int numZero = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(hashMap.containsKey(nums[i]+nums[j])){
                    List<Integer> list1= hashMap.get(nums[i]+nums[j]);
                    list1.add(i);
                    list1.add(j);
                    hashMap.put(nums[i]+nums[j],list1);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    hashMap.put(nums[i]+nums[j],list);
                }
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(hashMap.containsKey(-(nums[i]))){
                List<Integer> list = new ArrayList<>();
                List<Integer> mapList = hashMap.get(-(nums[i]));
                for(int j = 0;j<mapList.size()-1;j = j + 2){
                    list.clear();
                    if(i==mapList.get(j)||i==mapList.get(j+1)){
                        continue;
                    }else{
                        if(i<j) {
                            list.add(nums[mapList.get(j)]);
                            list.add(nums[mapList.get(j + 1)]);
                            list.add(nums[i]);
                            lists.add(list);
                        }
                    }
                }
                hashMap.remove(-(nums[i]));
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        return lists;
    }
    /**
     * 避免重复 所以先排序
     */
    public List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
