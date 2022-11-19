https://leetcode.com/problems/merge-k-sorted-lists/submissions/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(ListNode currNode : lists){
            
            ListNode head = currNode;
            while(head != null){
                pq.add(head.val);
                head = head.next; 
            }
        }
        
        System.out.println(pq);
        
        ListNode prev = new ListNode(-1);
        ListNode head = prev; 
        
        while(!pq.isEmpty()){
            head.next = new ListNode(pq.poll());
            head = head.next; 
        }
        
        return prev.next; 
    }
}