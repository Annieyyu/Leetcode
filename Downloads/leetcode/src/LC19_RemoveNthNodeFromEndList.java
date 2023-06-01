public class LC19_RemoveNthNodeFromEndList {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,1,3};
        int n = 2;
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
        LC19_RemoveNthNodeFromEndList m = new LC19_RemoveNthNodeFromEndList();
        // Print the linked list
        ListNode current = m.removeNthFromEnd(head,n);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(count < n && fast != null){
            fast = fast.next;
            count++;
        }
        //这条是判断当n的值等于LinkedList的节点个数的时候的情况，很关键
        if(fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}
