package Base;

public class ReverseWordsString {
    public String reverseWords(String s) {
        s.trim();
        String[] array = s.split("( )+");
        s = "";
        for(int i = array.length-1; i>=0 ;i--){
            s = s + array[i] + " ";
        }
        return s.trim();
    }
}
