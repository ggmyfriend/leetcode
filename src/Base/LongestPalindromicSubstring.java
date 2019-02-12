package Base;

/**
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.


 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int [][] matrix = new int[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
            matrix[i][i] = 1;
        }
        int maxi = 1,maxj = 0;
        for(int i = 1;i<s.length();i++){
            for(int j = 0;j+i<s.length();j++) {
                if(i==1){
                    if(s.charAt(j)==s.charAt(j+i)){
                        matrix[j][j+i] = 2;
                        if(maxi < i + 1){
                            maxi = i + 1;
                            maxj = j;
                        }
                    }else{
                        matrix[j][j+i] = 1;
                    }
                }else{
                    if(s.charAt(j)==s.charAt(j+i) && matrix[j+1][j+i-1] == i-1){
                        matrix[j][j+i] = matrix[j+1][j+i-1] + 2;
                        if(maxi < i + 1){
                            maxi = i + 1;
                            maxj = j;
                        }
                    }else{
                        matrix[j][j+i] = matrix[j+1][j+i-1];
                    }
                }
            }
        }
        return s.substring(maxj,maxi+maxj);
    }
}
