public class LC86_PartitionList {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,5,2};
        int target = 3;
        // Create the linked list
        ListNode head = null;
        ListNode prev = null;
        for (int num : nums) {
            ListNode newNode = new ListNode(num);
            if (head == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }
        LC86_PartitionList m = new LC86_PartitionList();
        // Print the linked list
        ListNode current = m.partition(head,target);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode partition(ListNode head, int target) { // self explained vairiable naming
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode c1 = dummy1;
        ListNode c2 = dummy2;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < target) {
                c1.next = cur;
                c1 = c1.next;
            }else {
                c2.next = cur;
                c2 = c2.next;
            }
            cur = cur.next;
        }
        c2.next = null;

        c1.next = dummy2.next;
        return dummy1.next;
    }


}
