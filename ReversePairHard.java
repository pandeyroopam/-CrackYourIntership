import java.util.Arrays;

public class ReversePairHard{
  public static int count = 0;
    public static int[] merge(int nums[]){
        if(nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
          int left[] = merge(Arrays.copyOfRange(nums, 0, mid));
          int right[] = merge(Arrays.copyOfRange(nums, mid, nums.length));
            return joint(left, right);
   }
   
   public static int[] joint(int[] first, int[] second){
    int mix[] = new int[first.length+ second.length];
    int i = 0, j = 0, k = 0;
    while (i < first.length && j < second.length) {
        if (first[i] > 2L * second[j]) {
            count += first.length - i;
            j++;
        } else {
            i++;
        }
    }

    i = 0;
    j = 0;

    // Merge the two sorted arrays.
    while (i < first.length && j < second.length) {
        if (first[i] <= second[j]) {
            mix[k++] = first[i++];
        } else {
            mix[k++] = second[j++];
        }
    }
    while(i < first.length){
        mix[k] = first[i];
        k++;
        i++;
    }while(j < second.length){
        mix[k] = second[j];
        k++;
        j++;
    }
    return mix;
   }
    



    public static int reversePair(int arr[]){
          merge(arr);
          return count;
    }
    public static void main(String[] args) {
        int arr[] = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePair(arr));
    }
}