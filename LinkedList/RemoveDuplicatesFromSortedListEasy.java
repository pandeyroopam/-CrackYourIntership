public class RemoveDuplicatesFromSortedListEasy {
    
    public static class List{
        int val;
        List next = null;
        List(int val){
            this.val = val;
        }
    }

    public static void removeDuplicate(List head){
        if(head == null){
            return ;
        }
        List temp = head;
        while(temp.next != null && temp != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        List head = new List(1);
        head.next = new List(1);
        head.next.next = new List(2);
        removeDuplicate(head);
        List temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
