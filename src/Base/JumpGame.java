package Base;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
    public boolean BadCanJump(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        int index = list.indexOf(new Integer(0));
        int temp = index;
        while(index<nums.length&&index!=-1){
            index  = maxCanJump(list.subList(0,index)) + 1;
            if(index >= nums.length){
                break;
            }
            if(temp == index){
                return false;
            }
            temp = index;
        }
        return true;
    }
    public int maxCanJump(List<Integer> list){
        int max = 0;
        for(int i = 0;i<list.size();i++){
            if((i+list.get(i))>max){
                max = i + list.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{1,1,2,2,0,1,1}));
    }
}
