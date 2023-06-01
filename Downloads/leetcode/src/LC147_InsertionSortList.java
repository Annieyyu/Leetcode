public class LC147_InsertionSortList {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,3};

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
        LC147_InsertionSortList n = new LC147_InsertionSortList();
        // Print the linked list
        ListNode current = n.insertionSortList(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        //inserttion sort的思路是双指针站肩，先确定一个j，j从1开始。先将j的位置的值cache出来，然后设置一个指针i， i从j-1往前走。遇到比j的值大的值
        //的时候，i的值就往后移动一位，直到不能移动位置。这时候，再把j的位置的值insert进去
        if(head == null || head.next == null) return head;
        ListNode cur = head;//用来遍历原来的linkedlist
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode insertNode = null;
        while(cur != null){
            prev = dummy;//每次loop，都需要将sorted好的LinkedList遍历一遍，找到可以插入的node
            while(prev.next != null && cur.val > prev.next.val){//如果新的orted list中的值小于cur.val的话，就继续往后走，直到比cur大的
                prev = prev.next;
            }

            insertNode = cur;
            cur = cur.next;
            insertNode.next = prev.next;
            prev.next = insertNode;

        }
        return dummy.next;
    }

}
