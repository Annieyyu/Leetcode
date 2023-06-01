public class LC25_ReverseLinkedlistByK {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        int k = 3;
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
        LC25_ReverseLinkedlistByK n = new LC25_ReverseLinkedlistByK();
        // Print the linked list
        ListNode current = n.reverseKGroup(head,k);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode next = dummy;
        int count = 0;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }
        while(count >= k){
            curr = prev.next;
            next = curr.next;
            for(int i = 1; i < k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
}
