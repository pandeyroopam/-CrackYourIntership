import java.util.PriorityQueue;

public class FurthestBuildingYouCanReachMedium {

    public static int furthestBuilding(int arr[], int bricks, int ladder){
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           int b = bricks;
           int l = ladder;
           int count = 0;
           while(count < arr.length-1 ){
              if(arr[count] >= arr[count+1]){
                count++;
                continue;
              }
                int gap = arr[count+1]-arr[count];
                  pq.add(gap);
                  if(pq.size() > ladder){
                     bricks -= pq.poll();
                  }
                  if(bricks < 0){
                    return count;
              }
              count++;

           }
           return count;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladder = 1;
        System.out.println(furthestBuilding(arr, bricks, ladder)); 
    }
}
