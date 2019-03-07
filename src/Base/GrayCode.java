package Base;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);                                //n=0 {0}
        if(n == 0) return list;
        int increase = 1;
        for(int i = 0;i<n;i++){                     //              n=2
            int len = list.size();                  //              len = 2
            for(int j = len-1;j>=0;j--){            //              {0,1,3,2}
                list.add(list.get(j)+increase);     //n=1 {0,1}
            }
            increase *= 2;
        }
        return list;
    }
}
