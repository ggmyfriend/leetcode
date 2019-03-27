package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                    return -1;
                else if(o1.length()==o2.length())
                    return 0;
                else
                    return 1;
            }
        });
        return recurWordBreak(s,wordDict);
    }
    public boolean recurWordBreak(String s,List<String> wordDict){
        if(s.equals("")){
            return true;
        }else{
            boolean workBreak = false;
            for(String word:wordDict){
                if(word.length()<=s.length()) {
                    if (s.substring(0, word.length()).equals(word)) {
                        workBreak = recurWordBreak(s.substring(word.length()), wordDict);
                        if (workBreak == true) {
                            break;
                        }
                    }
                }
            }
            return workBreak;
        }
    }
    //faster method
    public boolean wordBreakO2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }
    public static void main(String[] args) {
        /*WordBreak wordBreak = new WordBreak();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aaaaaaa");
        System.out.println(wordBreak.wordBreak("leetcode",list));
        System.out.println(list);*/
        String s = "asdbad";
        System.out.println(s.indexOf("as"));
    }
}
