public class LC21_MergeTwoSortedList {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4};
        int[] nums2 = new int[]{1,3,4};

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
        LC21_MergeTwoSortedList n = new LC21_MergeTwoSortedList();
        // Print the linked list
        ListNode current = n.mergeTwoLists(head1,head2);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;

        ListNode head, cur;
        if ( l1.val < l2.val ){
            head = l1;
            l1 = l1.next;
        } else{
            head = l2;
            l2 = l2.next;
        }
        cur = head;
        while ( l1 != null && l2 != null ){
            if ( l1.val < l2.val ){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if ( l1 != null ) cur.next = l1;
        if ( l2 != null ) cur.next = l2;
        return head;
    }

}
