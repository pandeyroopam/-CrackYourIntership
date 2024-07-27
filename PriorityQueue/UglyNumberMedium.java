import java.util.*;
public class UglyNumberMedium{

    public static int nthUglyNumber(int n){
       PriorityQueue<Long> pq = new PriorityQueue<>();
       HashMap<Long, Integer> map = new HashMap<>();
       int count = 0;
       map.put(1L, 1);
       pq.add(1L);
       long x = 0;
       while(count != n){
         x = pq.remove();
        count++;
        if(!map.containsKey(2*x)){
            map.put(2*x, 1);
            pq.add(2*x);
        }
        if(!map.containsKey(3*x)){
            map.put(3*x, 1);
            pq.add(3*x);
        }
        if(!map.containsKey(5*x)){
            map.put(5*x, 1);
            pq.add(5*x);
        }
       }
       return (int)x;

    }
    public static void main(String[] args) {
        int n = 1407;
        System.out.println(nthUglyNumber(n));
    }
}