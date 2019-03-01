package Base;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        int index = 0;
        ArrayList<String> filePath = new ArrayList<>();
        StringBuilder result = new StringBuilder("/");
        String[] strings = path.split("/+");
        if(strings.length==0){
            return result.toString();
        }
        else{
            for(int i = 1;i<strings.length;i++){
                if(strings[i].matches("\\.")){
                    continue;
                }
                else if(strings[i].matches("\\.\\.")) {
                    if (index != 0){
                        filePath.remove(index - 1);
                        index--;
                    }
                }else{
                    filePath.add(strings[i]);
                    index++;
                }
            }
        }
        for(int i = 0;i<filePath.size();i++){
            if(i!=filePath.size()-1){
                result.append(filePath.get(i) + "/");
            }else{
                result.append(filePath.get(i));
            }
        }
        return result.toString();
    }
    private void printStrings(String [] s){
        System.out.println(s.length);
        for (String temp :s){
            System.out.println(","+temp+",");
        }
    }
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/././././."));
    }
}
