package Base;

import java.util.ArrayList;
import java.util.List;

/**
 Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.


 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        List<Integer> list = new ArrayList<>();
        int tempx = x;
        while(tempx != 0){
            list.add(tempx % 10);
            tempx = tempx / 10;
        }
        for(int i = 0,j = list.size()-1;i<j&&list.size()!=0;i++,j--){
           // System.out.println(list.size());
            if(list.get(i)!=list.get(j))
                return false;
        }
        return true;
    }
}
