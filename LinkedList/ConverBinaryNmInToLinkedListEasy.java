import java.util.*;

public class ConverBinaryNmInToLinkedListEasy {

    public static class List{
        int val;
         List next= null;
        public List(int val){
            this.val = val;
        }
    }

    public static int BinToNum(List head){
       ArrayList<Integer> list = new ArrayList<>();
       int ans = 0;
        while(head != null){
          list.add(head.val);
          head = head.next;
        }
        for(int i = 0 ; i<list.size(); i++){
            int val = list.get(list.size()-1-i);
               ans += (int)val*Math.pow(2, i);
        }
        return ans;
    }
    public static void main(String[] args) {
        List head = new List(0);
        
        System.out.println(BinToNum(head));

    }
}
