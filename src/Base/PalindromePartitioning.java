package Base;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> lists;
    public List<List<String>> partition(String s) {
        lists = new ArrayList<>();
        if(s.length()==0){
            return lists;
        }
        recurPartition(s,0);
        return lists;
    }
    public void recurPartition(String s,int index){
        if(index == 0){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(s.charAt(index)));
            lists.add(list);
            recurPartition(s,1);
        }
        else if(s.length() == index){
            return;
        }
        else{
            int size = lists.size();
            for(int i = 0;i<size;i++){
                List<String> list = lists.get(i);
                String end1 = null;
                if(list.size()>=1) {
                   end1 = list.get(list.size() - 1);
                }
                String end2 = null;
                if(list.size()>=2) {
                   end2 = list.get(list.size() - 2);
                }
                if(end1 != null) {
                   if (isPalindrome(end1, String.valueOf(s.charAt(index)))) {
                      List<String> tempList = new ArrayList<>(list);
                      tempList.remove(list.size()-1);
                      tempList.add(end1+String.valueOf(s.charAt(index)));
                      lists.add(tempList);
                   } else {
                       if(end2 != null){
                           if (isPalindrome(end2+end1, String.valueOf(s.charAt(index)))) {
                               List<String> tempList = new ArrayList<>(list);
                               tempList.remove(list.size()-1);
                               tempList.remove(list.size()-2);
                               tempList.add(end2+end1+String.valueOf(s.charAt(index)));
                               lists.add(tempList);
                        }
                    }
                  }
              }
              list.add(String.valueOf(s.charAt(index)));
            }
            recurPartition(s,index+1);
        }
    }
    public boolean isPalindrome(String pre,String bot){
        String s = pre + bot;
        int i = 0,j=s.length()-1;
        while(i<j){
           if(s.charAt(i)!=s.charAt(j)){
               return false;
           }
           i++;
           j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("baaab");
        System.out.println(palindromePartitioning.lists);
    }
}
