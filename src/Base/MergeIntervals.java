package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "start:"+start+" end:"+end;
    }
}
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        Collections.sort(intervals,(Interval o1,Interval o2)->{
            /*if(o1.start>o2.start){
                return 1;
            }else if(o1.start==o2.start){
                return 0;
            } {
                return -1;
            }*/
            return o1.start - o2.start;
        });
        while(intervals.size()>0){
           Interval interval = intervals.remove(0);
           int index = 0;
           while(index < intervals.size()){
               if(interval.end>=intervals.get(index).start){
                   if(interval.end < intervals.get(index).end)
                        interval.end = intervals.get(index).end;
                   intervals.remove(index);
               }else{
                   index++;
               }
           }
           list.add(interval);
        }
        return list;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(2,3));
        System.out.println(mergeIntervals.merge(list));
    }
}
