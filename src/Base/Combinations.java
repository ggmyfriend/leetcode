package Base;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> lists;
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList();
        calculateCombine(list,n,k);
        return lists;
    }
    public void calculateCombine(List<Integer> list,int n,int k){
        if(k==1){
            for(int i = 1;i<=n;i++){
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(i);
                lists.add(tempList);
            }
            return;
        }else{
            list.add(n);
            calculateCombine(list,n-1,k-1);
            list.remove(new Integer(n));
            if(n-1>=k) {
                calculateCombine(list, n - 1, k);
            }
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(10,2));
    }
}
