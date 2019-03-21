package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<triangle.size();i++){
            for(int j = 0;j<triangle.get(i).size();j++){
                int tempNum = triangle.get(i).get(j);
                int tempMin = Integer.MAX_VALUE;
                if(j-1>=0&&j-1<triangle.get(i-1).size()){
                    if((triangle.get(i-1).get(j-1)+tempNum)<tempMin){
                        tempMin = triangle.get(i-1).get(j-1)+tempNum;
                    }
                }
                if(j<triangle.get(i-1).size()){
                    if((triangle.get(i-1).get(j)+tempNum)<tempMin){
                        tempMin = triangle.get(i-1).get(j)+tempNum;
                    }
                }
                triangle.get(i).set(j,tempMin);
            }
        }
        for(Integer integer : triangle.get(triangle.size()-1)){
            if(min>integer){
                min = integer;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList();
        list.add(new ArrayList<>(Arrays.asList(new Integer(2))));
        list.add(new ArrayList<>(Arrays.asList(new Integer(3),new Integer(4))));
        list.add(new ArrayList<>(Arrays.asList(new Integer(6),new Integer(5),new Integer(7))));
        list.add(new ArrayList<>(Arrays.asList(new Integer(4),new Integer(1),new Integer(8),new Integer(3))));
        List<List<Integer>> list1 = new ArrayList();
        list1.add(new ArrayList<>(Arrays.asList(new Integer(-1))));
        list1.add(new ArrayList<>(Arrays.asList(new Integer(2),new Integer(3))));
        list1.add(new ArrayList<>(Arrays.asList(new Integer(1),new Integer(-1),new Integer(-3))));
        Triangle triangle1 = new Triangle();
        System.out.println(triangle1.minimumTotal(list1));
    }
}
