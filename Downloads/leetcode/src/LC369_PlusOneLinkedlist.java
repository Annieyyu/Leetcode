

    public class LC369_PlusOneLinkedlist {
        public static void main(String[] args) {
            int[] nums = new int[]{9,9,9};
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
            LC369_PlusOneLinkedlist m = new LC369_PlusOneLinkedlist();
            // Print the linked list
            ListNode current = m.plusOne(head);
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }
        public ListNode plusOne(ListNode head) {
            if (head == null) return head;

            ListNode res = new ListNode(0);
            res.next = head;
            ListNode curr = head;
            ListNode notNine = res;

            while(curr != null){
                if(curr.val != 9){
                    notNine = curr;
                }
                curr = curr.next;
            }
            notNine.val++;
            notNine = notNine.next;

            while(notNine!= null){
                notNine.val = 0;
                notNine = notNine.next;
            }
            return res.val == 0 ? res.next:res;


        }
    }

