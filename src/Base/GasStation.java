package Base;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0,sumCost = 0;
        for(int i = 0;i<gas.length;i++){
            sumCost += cost[i];
            sumGas += gas[i];
        }
        if(sumCost>sumGas)
            return -1;
        else {
            for (int i = 0; i < gas.length; i++) {
                if (gas[i] >= cost[i]) {
                    if (canCircuit(gas, cost, i)) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
    public boolean canCircuit(int[] gas,int[] cost,int index){
        int remainderGas = 0;
        for(int i = 0;i<gas.length;i++){
            remainderGas += gas[(i+index)%gas.length];
            remainderGas -= cost[(i+index)%gas.length];
            if(remainderGas<0){
                return false;
            }
        }
        return true;
    }
    //O(n)
    public int canCompleteCircuitOn(int[] gas, int[] cost) {
        int start = gas.length-1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                ++end;
            }
            else {
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;

    }
    public static void main(String[] args) {
        int[] gas  = {2,3,4};
        int[] cost = {3,4,3};
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas,cost));
    }
}
