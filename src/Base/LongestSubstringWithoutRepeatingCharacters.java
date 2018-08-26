package Base;


import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 * Examples:

 * Given "abcabcbb", the answer is "abc", which the length is 3.

 * Given "bbbbb", the answer is "b", with the length of 1.

 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxNumber = 1;
        for(int i = 1; i < s.length();i++){
            HashMap<Character,Object> hashMap = new HashMap<>();
            for(int j = 0;j < i;j++){
                if(i-j+1<maxNumber){
                    break;
                }
                hashMap.clear();
                for (int x = j;x<=i;x++){
                    hashMap.put(s.charAt(x),new Object());
                }
                int length = hashMap.size();
                if((length == i-j+1) && length > maxNumber){
                    maxNumber = length;
                }
            }
        }
        return maxNumber;
    }
    /**
     * 官方提供的better solution
     */
    public static int BetterSolution(String s){
        int i=0,j=0,ans = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while(i<s.length()&&j<s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                if(j-i+1>ans){
                    ans = j-i+1;
                }
                j++;
            }
            else{
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
