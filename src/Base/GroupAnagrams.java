package Base;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
    //过慢过多
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> lists = new ArrayList<>();
        while (list.size() > 0){
            List<String> tempList = new ArrayList<>();
            tempList.add(list.get(0));
            int lenth = list.get(0).length();
            String removeString = list.remove(0);
            HashMap<String,Integer> hashMap = new HashMap<>();
            //先获取所有的String的个数
            int index = 0;
            while(index<lenth){
                String temp = removeString.substring(index,index+1);
                if(hashMap.containsKey(temp)){
                    hashMap.put(temp,hashMap.get(temp)+1);
                }else{
                    hashMap.put(temp,1);
                }
                index++;
            }
            for(int i = 0;i<list.size();i++){
                if(isAnagrams(hashMap,list.get(i))){
                    tempList.add(list.get(i));
                    list.remove(i);
                    i--;
                }
            }
            lists.add(new ArrayList<>(tempList));
        }
        return lists;
    }
    public boolean isAnagrams(HashMap<String,Integer> hashMaps,String s){
        HashMap<String,Integer> hashMap = new HashMap(hashMaps);
        int lenth = s.length();
        int index = 0;
        while(index<lenth){
            String temp = s.substring(index,index+1);
            if(hashMap.containsKey(temp)){
                int tempNum = hashMap.get(temp);
                if(tempNum == 1){
                    hashMap.remove(temp);
                }else{
                    hashMap.put(temp,tempNum-1);
                }
            }else{
                return false;
            }
            index++;
        }
        if(index == lenth && hashMap.size() == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String [] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

}
