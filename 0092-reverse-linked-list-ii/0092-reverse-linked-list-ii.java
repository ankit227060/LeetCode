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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ArrayList<Integer> arr = new ArrayList<>();

        ListNode temp = head;
        
            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        

        int l=left-1;
        int r=right-1;

        while(l<r){
            int swap=arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,swap);
            r--;
            l++;
        }

        int i=0;
        temp=head;
        while(temp!=null){
            temp.val=arr.get(i);
            i++;
            temp=temp.next;
        }

        return head;
    }
}