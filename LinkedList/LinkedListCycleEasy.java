// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

public class LinkedListCycleEasy{

    public static class List{
        int val;
         List next= null;
        public List(int val){
            this.val = val;
        }
    }
    
    public static boolean isCycle(List head){
      List slow = head;
      List fast = head;
      while( fast.next != null && fast != null ){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return true;
        }
      }
        return false;
    }
  public static  void main(String[] args){
    List head = new List(1);
    
    System.out.println(isCycle(head));

  }
}