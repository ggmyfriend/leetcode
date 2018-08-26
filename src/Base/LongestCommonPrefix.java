package Base;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer str = new StringBuffer();
        int j = 0,i = 0;
        while(i<strs.length){
            try{
                if(strs[i].charAt(j)!=strs[0].charAt(j)){
                    break;
                }
                if (i == strs.length - 1) {
                    str.append(strs[0].charAt(j));
                    i = 0;
                    j++;
                }
                i++;
            }catch (Exception e){
                break;
            }
        }
        return str.toString();
    }
}
