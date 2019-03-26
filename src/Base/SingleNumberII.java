package Base;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    //need extra memory
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i : nums){
            if(hashMap.containsKey(i)){
                Integer num = hashMap.get(new Integer(i));
                num++;
                hashMap.put(i,num);
            }else{
                hashMap.put(i,1);
            }
        }
        int returnValue = 0;
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()==1){
                returnValue = entry.getKey();
                break;
            }
        }
        return returnValue;
    }
}
