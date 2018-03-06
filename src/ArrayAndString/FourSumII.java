package ArrayAndString;

import java.lang.ref.SoftReference;

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
    public static void main(String []args){
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        System.out.println(Solution(A,B,C,D));
    }
}
