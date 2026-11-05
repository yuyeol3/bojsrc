import java.util.*;

class Solution {
    
    int toSerial(String timeString) {
        StringTokenizer st = new StringTokenizer(timeString, ":");
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h * 60 + m;
    }
    
    public List<Integer> solution(int[] fees, String[] records) {
        
        int defTime = fees[0];
        int defCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
        
        Map<String, Integer> enteredOn = new HashMap<>();
        Map<String, Integer> aggParkingTime = new HashMap<>();
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            
            int time = toSerial(st.nextToken());
            String carNum = st.nextToken();
            String op = st.nextToken();
            
            if (op.equals("IN")) {
                enteredOn.put(carNum, time);
            }
            else {
                int enterTime = enteredOn.get(carNum);
                int parkedPeriod = time - enterTime;                
                aggParkingTime.merge(carNum, parkedPeriod, Integer::sum);
                enteredOn.remove(carNum);
            }
        }
        
        int finalTime = toSerial("23:59");
        for (String carNum : enteredOn.keySet()) {
            int enterTime = enteredOn.get(carNum);
            int parkedPeriod = finalTime - enterTime;
            aggParkingTime.merge(carNum, parkedPeriod, Integer::sum);
        }
        
        return aggParkingTime
                .entrySet()
                .stream()
                .sorted(
                    (a, b)->Integer.compare(
                        Integer.parseInt(a.getKey()), 
                        Integer.parseInt(b.getKey())
                    )
                )
                .map(v->calcCost(defTime, defCost, unitTime, unitCost, v.getValue()))
                .toList();                                 
    }
    
    int calcCost(int defTime, int defCost, int unitTime, int unitCost, int parkedPeriod) {
        if (parkedPeriod <= defTime) {
            return defCost;
        }
        else {
            return defCost + (
                (parkedPeriod - defTime + unitTime - 1) / unitTime
            ) * unitCost;
        }
    }
    
    
}