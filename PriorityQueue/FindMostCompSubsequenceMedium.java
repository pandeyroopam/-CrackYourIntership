import java.util.*;
public class FindMostCompSubsequenceMedium {
    
    public static class PointInfo implements Comparable<PointInfo>{
        int val;
        int idx;
        PointInfo(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(PointInfo p1){
            if(this.val == p1.val){
                return this.idx - p1.idx;
            }
            return this.val - p1.val;
        }
    }
    public static int[] mostCompetitive(int nums[],int k){
        PriorityQueue<PointInfo> pq = new PriorityQueue<>();
        int i ;
        for( i = 0; i <= nums.length-k; i++){
            pq.add(new PointInfo(nums[i], i));
        }
        int arr[] = new int[k];
        PointInfo small = pq.remove();
        arr[0] = small.val;
        int idx = small.idx;
        int j = 1;
        while(j < k){
          pq.add(new PointInfo(nums[i], i));
          i++;
          while(idx > pq.peek().idx){
            pq.remove();
          }
          arr[j] = pq.peek().val;
          idx = pq.peek().idx;
          j++;
          pq.remove();
        }
        return arr;
    }

    //   another way to solve the same problem
    public static int[] mostCompetitive1(int arr[], int k){
        Stack<Integer> s =  new Stack<>();
        for(int i =0; i < arr.length; i++){
            while(s.size() > 0 && s.peek() > arr[i] && arr.length - i-1 >= k - s.size()){
                s.pop();
            }
            if(k-s.size() > 0){
                s.push(arr[i]);
            }
        }
          int ans[] = new int[k];
          while(k > 0){
            ans[k-1] = s.pop();
            k--;
          }
          return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,3,3,5,4,9,6};
        int k = 4;
        System.out.println(Arrays.toString(mostCompetitive(arr, k)));
    }
}
