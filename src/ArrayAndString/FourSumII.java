package ArrayAndString;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class FourSumII {
    public static int Solution(int[] A, int[] B, int[] C, int[] D){
        int fourSumNumberEqualsZero = 0;
        int length = A.length;
        for(int i = 0;i<length;i++) {
            for(int j = 0;j<length;j++){
                for(int x = 0;x<length;x++){
                    for(int y = 0;y<length;y++){
                        if(A[i]+B[j]+C[x]+D[y] == 0){
                            fourSumNumberEqualsZero++ ;
                        }
                    }
                }
            }
        }
        return fourSumNumberEqualsZero;
    }
    /**
     * @desciption 更好的方法 之前的方法为o(n^4)可以降低到更低使用Set
     * @return
     */
    public static int betterSolution(int[] A, int[] B, int[] C, int[] D){
        int fourSumNumberEqualsZero = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int i = 0,j=0;
        for(i=0;i<A.length;i++){
            for(j = 0;j<B.length;j++){
                int sum = A[i] + B[j];
                if(!hashMap.containsKey(sum)){
                    hashMap.put(sum,1);
                }
                else{
                    int number = hashMap.get(sum)+1;
                    hashMap.put(sum,number);
                }
            }
        }
        for(i=0;i<C.length;i++){
            for(j = 0;j<D.length;j++){
                int sum = C[i]+D[j];
                if(hashMap.containsKey(-sum)){
                    fourSumNumberEqualsZero = fourSumNumberEqualsZero + hashMap.get(-sum);
                }
            }
        }
        return fourSumNumberEqualsZero;
    }
    public static void main(String []args){
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        System.out.println(betterSolution(A,B,C,D));
    }
}
