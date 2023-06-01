import java.util.Arrays;
import java.util.List;


public class LC23_MergeKSortedList {

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 4, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(2, 6)
        );

        LC23_MergeKSortedList m = new LC23_MergeKSortedList();
        ListNode result = m.mergeKLists(lists);
        printList(result);
    }

    public ListNode mergeKLists(List<List<Integer>> lists) {
        // cc
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            nodes[i] = convertToLinkedList(lists.get(i));
        }
        return divideAndConquer(nodes, 0, nodes.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode left = divideAndConquer(lists, lo, mid);
        ListNode right = divideAndConquer(lists, mid + 1, hi);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                head.next = n1;
                n1 = n1.next;
            } else {
                head.next = n2;
                n2 = n2.next;
            }
            head = head.next;
        }
        head.next = (n1 != null) ? n1 : n2;
        return dummy.next;
    }

    private ListNode convertToLinkedList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : list) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
