public class MergeTwoSortedListEasy {

    public static class List{
        int val;
        List next = null;
        List(int val){
            this.val = val;
        }
    }

    public static void display(List head){
        List temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static List merge(List h1, List h2){
        if(h1 == null && h2 == null){
            return null;
        }
        List head = new List(0);
        List temp = head;
         while(h1 != null && h2 != null){
             if(h1.val < h2.val){
               temp.next = h1;
               h1 = h1.next;
               temp = temp.next;
             }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
             }
         }
            if(h1 != null){
                temp.next = h1;
            }
            if(h2 != null){
                temp.next = h2;
            }
         return head.next;
    }
    public static void main(String[] args) {
        List l1 = new List(1);
        l1.next = new List(2);
        l1.next.next = new List(4);

        List l2 = new List(1);
        l2.next = new List(3);
        l2.next.next = new List(4);

        List mix = merge(l1, l2);
        display(mix);
    }
}
