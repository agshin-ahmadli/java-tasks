package task1;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        this.val = x;
    }
}

class LinkedListReversal {
    public static ListNode reverseInGroups(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode newHead = null;
        ListNode groupPrevEnd = null;
        ListNode current = head;

        while (current != null) {
            ListNode groupStart = current;
            ListNode groupEnd = current;

            for (int i = 1; i < k && groupEnd.next != null; i++) {
                groupEnd = groupEnd.next;
            }

            ListNode nextGroupStart = groupEnd.next;

            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (newHead == null) {
                newHead = groupEnd;
            }

            if (groupPrevEnd != null) {
                groupPrevEnd.next = groupEnd;
            }

            groupPrevEnd = groupStart;

            current = nextGroupStart;
        }

        return newHead;
    }



    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);


        System.out.println("Original List:");

        printList(head);
        int k = 3;
        head = reverseInGroups(head, k);
        System.out.println("Reversed List in Groups of " + k + ":");
        printList(head);

    }

}