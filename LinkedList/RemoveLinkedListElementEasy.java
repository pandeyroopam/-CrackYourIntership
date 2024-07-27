public class RemoveLinkedListElementEasy {
        public static class List{
            int val;
            List next = null;
            List(int val){
                this.val = val;
            }
        }

       public static void RemoveValue(List head, int val){
        if(head == null){
            return ;
        }
        while(head != null && head.val == val){
            head = head.next;
        }
        List temp = head;
        while( temp != null && temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
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
    public static void main(String[] args) {
     List head = new List(1);
     head.next = new List(2);
     head.next.next = new List(6);
     head.next.next.next = new List(3);
     head.next.next.next.next = new List(4);
     head.next.next.next.next.next = new List(5);
     head.next.next.next.next.next.next = new List(6);
     int val = 6 ;
     display(head);
      RemoveValue(head, val);
      display(head);
    }
}
