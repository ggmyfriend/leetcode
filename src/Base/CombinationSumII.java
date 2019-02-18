package Base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {
    public static List<List<Integer>> lists;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursionSum(candidates,target,list,0,0);
        return lists;
    }
    public void recursionSum(int[] candidates,int target,List<Integer> list,int sum,int index){
        if(sum == target){
            List<Integer> list1 = new ArrayList<>(list);
            lists.add(list1);
        }
        else if(sum > target){
            return;
        }
        else{
            if(index<candidates.length) {
                if (index > 0 && candidates[index - 1] == candidates[index]) {
                    if (!list.contains(candidates[index]))
                        recursionSum(candidates, target, list, sum, index + 1);
                    else {
                        sum = sum + candidates[index];
                        list.add(candidates[index]);
                        recursionSum(candidates, target, list, sum, index + 1);
                        list.remove(list.lastIndexOf(candidates[index]));
                        sum -= candidates[index];
                        while (index < candidates.length && candidates[index - 1] == candidates[index]) {
                            index++;
                        }
                        recursionSum(candidates, target, list, sum, index);
                    }
                } else {
                    recursionSum(candidates, target, list, sum, index + 1);
                    sum = sum + candidates[index];
                    list.add(candidates[index]);
                    recursionSum(candidates, target, list, sum, index + 1);
                    list.remove(list.lastIndexOf(candidates[index]));
                }
            }else{
                return;
            }
        }
    }
    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        System.out.println(combinationSum.combinationSum2(new int[]{1,1},2));
    }
}
