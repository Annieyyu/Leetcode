

public class LC206_ReverseLinkedlist {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 7, 5, 1, 11, 2};

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
        LC206_ReverseLinkedlist n = new LC206_ReverseLinkedlist();
        // Print the linked list
        ListNode current = n.reverseList(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}