class ListNode {
  int data;
  ListNode next;

  public ListNode(int val) {
    this.data = val;
  }
}

public class main {
  // Insertion at front O(1)
  private ListNode addElementsFront(ListNode head, int nodeVal) {
    ListNode newNode = new ListNode(nodeVal);
    newNode.next = head;
    head = newNode;
    return newNode;
  }

  // Insertion at end O(n)
  private ListNode addElementsLast(ListNode head, int nodeVal) {
    // if (head == null)
    //   return new LinkedList(nodeVal);

    ListNode dummyNode = new ListNode(-1);

    ListNode curr = dummyNode;
    while (curr.next != null) {
      curr = curr.next;
    }
    ListNode newNode = new ListNode(nodeVal);
    curr.next = newNode;
    return dummyNode.next;
  }

  //time complexity O(1)
  private ListNode insertBetween(ListNode head, ListNode n1, ListNode n2, int val){
    ListNode newNode = new ListNode(val);
    n1.next = newNode;
    newNode.next = n2; 
    return head; 
  }

  //time complexity O(1)
  private ListNode insertAfterNode(ListNode head, ListNode n1, int val){
    ListNode newNode = new ListNode(val);

    ListNode nextNode = n1.next; 
    n1.next = newNode; 
    newNode.next = nextNode;
    return head; 
  }

  // time complexity O(1)
  private ListNode deleteFirst(ListNode head){
    if(head == null) return head; 
    head = head.next;
    return head; 
  }

  
  private ListNode deleteLast(ListNode head){

    // ListNode dummyNode = new ListNode(-1);
    // dummyNode.next = head;

    // ListNode curr = dummyNode; 
    // while(curr.next != null && curr.next.next != null){
    //   curr = curr.next;
    // }

    // curr.next = null; 
    // return dummyNode.next; 

    ListNode curr = head; 
    ListNode prev = null;

    while(curr.next != null){
      prev = curr;
      curr = curr.next;
    }

    prev.next = curr.next; 
    return head; 
  }
}