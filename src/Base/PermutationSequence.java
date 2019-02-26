package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        int types = 1;
        for(int i = n-1 ; i > 0 ; i--){
            types = types * i;
        }
        List<Character> list = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            list.add((char)(i+'0'));
        }
        int temp = n - 1;
        while(str.length()!=n){
            int tempN = 0;
            while(tempN * types < k){
                tempN++;
            }
            str.append(list.get(tempN - 1));
            list.remove(tempN - 1) ;
            k -= (((tempN-1)*types));
            if(temp != 0) {
                types /= temp;
            }
            temp--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(9,8));
    }
}
