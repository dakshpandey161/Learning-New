class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break;
            
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;
            
            reverse(groupStart, kthNode);
            
            prevGroupEnd.next = kthNode;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
    
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null, curr = start, next = null;
        ListNode stop = end.next;
        
        while (curr != stop) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
