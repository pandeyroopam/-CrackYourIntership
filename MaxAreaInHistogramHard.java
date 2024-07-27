import java.util.Stack;

public class MaxAreaInHistogramHard{
  
     public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int lsn[] = new int[heights.length];
        int rsn[] = new int[heights.length];
        
        // finding right side smallest element of each elt
        for(int i = heights.length-1; i >= 0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                rsn[i] = heights.length;
            }else{
                rsn[i] = s.peek();
            }
            s.push(i);
        }

                // finding left side smallest element of each elt


          s = new Stack<>();
         for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
             if(s.isEmpty()){
                lsn[i] = -1;
            }else{
                lsn[i] = s.peek();
            }
            s.push(i);
        }

        int max = 0;
        for(int i = 0 ; i< heights.length; i++){
            int area = heights[i]*(rsn[i] - lsn[i] -1);
             max = Math.max(max, area);
        }
        return max;
    }


    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
    }
}