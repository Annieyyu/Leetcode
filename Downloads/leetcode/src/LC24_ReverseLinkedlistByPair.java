public class LC24_ReverseLinkedlistByPair {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

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
        LC24_ReverseLinkedlistByPair n = new LC24_ReverseLinkedlistByPair();
        // Print the linked list
        ListNode current = n.swapPairs(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode postHead = swapPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;

        return newHead;
    }
}
