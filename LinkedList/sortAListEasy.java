public class sortAListEasy {

    public static class List{
        int val;
        List next = null;
        List(int val){
            this.val = val;
        }
    }

    public static void sortAscendingOrder(List head){
        int arr[] = new int[3];
        List temp = head;
        while(temp != null){
            arr[temp.val]++;
            temp = temp.next;
        }
        temp = head;
         for(int i =0; i < 3; i++){
            while(arr[i] > 0){
                temp.val = i;
                 temp = temp.next;
                 arr[i]--;
            }
         }
    }

    public static List sortAscendingOrder1(List curr){
        if(curr == null && curr.next == null){
            return curr;
        }
        List h1 = new List(0);
        List h2 = new List(0);
        List h3 = new List(0);

        List h11 = h1, h22 = h2, h33 = h3;
        List head = curr;
        while(head != null){
            if(head.val == 0){
              h11.next = head;
              h11 = h11.next;

            }else if(head.val == 1){
                h22.next = head;
                h22 = h22.next;
            }else{
                h33.next = head;
                h33 = h33.next;
            }
             head = head.next;
        }
        h33.next = null;
        
        h11.next = (h2.next != null) ? h2.next: h3.next;
        h22.next = h3.next;
        return h1.next;
    }

    public static void display(List head){
        List temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List head = new List(1);
        head.next = new List(1);
        head.next.next = new List(2);
        head.next.next.next = new List(0);
        head.next.next.next.next = new List(2);
        head.next.next.next.next.next = new List(0);
        head.next.next.next.next.next.next = new List(1);
            display(head);
            head = sortAscendingOrder1(head);
             display(head);
    }
}
