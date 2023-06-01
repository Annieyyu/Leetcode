public class LC160_LinkedlistCheckIntersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,8,4,5};
        int[] nums2 = new int[]{5,6,1,8,4,5};

        // Create the linked list
        ListNode head1 = null;
        ListNode prev1 = null;
        for (int num : nums1) {
            ListNode newNode = new ListNode(num);
            if (head1 == null) {
                head1 = newNode;
            } else {
                prev1.next = newNode;
            }
            prev1 = newNode;
        }
        ListNode head2 = null;
        ListNode prev2 = null;
        for (int num : nums2) {
            ListNode newNode = new ListNode(num);
            if (head2 == null) {
                head2 = newNode;
            } else {
                prev2.next = newNode;
            }
            prev2 = newNode;
        }
        LC160_LinkedlistCheckIntersection n = new LC160_LinkedlistCheckIntersection();
        // Print the linked list
        ListNode current = n.getIntersectionNode(head1,head2);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }
}
