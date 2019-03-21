package Base;

import java.util.*;

public class WordLadder {
    // Time Limit Exceeded
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int index = wordList.indexOf(endWord);
        if(index < 0){
            return 0;
        }else{
            return recurLadderLength(beginWord,endWord,wordList);
        }
    }
    public int recurLadderLength(String beginWord, String endWord, List<String> wordList){
        if(canNext(beginWord,endWord)==1){
            return 2;
        }else {
            int min = Integer.MAX_VALUE;
            int minStep = Integer.MAX_VALUE;
            for(int j = 0;j<beginWord.length();j++) {
                char[] chs = beginWord.toCharArray();
                for (int i = 'a'; i <= 'z'; i++) {
                    char old = chs[j];
                    chs[j] = (char)i;
                    if(wordList.contains(String.valueOf(chs))){
                        int index = wordList.indexOf(String.valueOf(chs));
                        String s = wordList.remove(index);
                        int temp = recurLadderLength(s, endWord, wordList) + 1;
                        wordList.add(index, String.valueOf(chs));
                        if (temp == 1) {
                            continue;
                        }
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    chs[j] = old;
                }
            }
            if(min==Integer.MAX_VALUE){
                return 0;
            }
            return min;
        }
    }
    public int canNext(String beginWord,String nextBegin){
        int different = 0;
        for(int i = 0;i<beginWord.length();i++){
            if(beginWord.charAt(i)!=nextBegin.charAt(i)){
                different++;
            }
        }
        return different;
    }
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        int index = wordList.indexOf(endWord);
        if(index < 0){
            return 0;
        }
        HashSet<String> hashSet = new HashSet<>(wordList);
        int len = 1;
        HashSet<String> begin = new HashSet<String>(Arrays.asList(beginWord));
        HashSet<String> end = new HashSet<String>(Arrays.asList(endWord));
        HashSet<String> visited = new HashSet<>();
        while(!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                HashSet<String> temp = begin;
                begin = end;
                end = temp;
            }
            HashSet<String> temp = new HashSet<>();
            for (String word : begin) {
                for(String wors : hashSet) {
                    int different = canNext(word,wors);
                    if (different==1){
                        if(end.contains(wors)){
                            return len+1;
                        }
                        if(!visited.contains(wors)){
                            temp.add(wors);
                            visited.add(wors);
                        }
                    }
                }
            }
            begin = temp;
            len++;
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList(Arrays.asList("hot","dot","dog","lot","log"));
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength1("hit","cog",list));
    }
}
