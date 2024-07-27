import java.util.HashMap;
public class LargestSubarraywith0SumMedium {

   public static int maxLen(int arr[], int n){
       int ps = 0; int maximum = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
       for(int i = 0; i < n; i++){
        ps += arr[i];
        if(map.containsKey(ps)){
            int x = i - map.get(ps);
            maximum = Math.max(maximum, x );
        }else{
            map.put(ps, i);
        }
       }
       return maximum;
    }
    public static void main(String[] args) {
        int arr[] = {-1, 1, -1, 1};
        int n = 4;
System.out.println(maxLen(arr, n));
    }
}
