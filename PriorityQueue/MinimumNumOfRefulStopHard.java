import java.util.*;

public class MinimumNumOfRefulStopHard{

    

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        if(stations.length <1){
            return -1;
        }
        int count =0 , maxDistReachable = startFuel;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(maxDistReachable < target){
          while(i < stations.length && maxDistReachable >= stations[i][0]){
            pq.add(stations[i][1]);
            i++;
          }
          if(pq.isEmpty()) return -1;
          count++;
          maxDistReachable += pq.remove();
        }

        return count;
    }
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 50;
        int[][] stations = {{50,50}
                       
                    };

      System.out.println(minRefuelStops(target, startFuel, stations));
    }
}