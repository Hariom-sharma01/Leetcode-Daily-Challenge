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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode ll=new ListNode();
       ListNode ans=ll;
        int c=0;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val+c;
            c=sum/10;
            ll.next=new ListNode(sum%10);
            ll=ll.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+c;
            c=sum/10;
            ll.next=new ListNode(sum%10);
            ll=ll.next;
             l1=l1.next;

        }
        while(l2!=null){
            int sum=l2.val+c;
            c=sum/10;
            ll.next=new ListNode(sum%10);
            ll=ll.next;
            
            l2=l2.next;
        }
        if(c>0)ll.next=new ListNode(c);
        return ans.next;
        
    }
}