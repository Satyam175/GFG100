package LinkedList;

class Solution {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next  = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode rev = reverseKGroup(first, 2);
        System.out.println(rev);
    }

  public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevGroupEnd = null;

        while (temp != null) {
            ListNode KthNode = findKNode(temp, k);
            if (KthNode == null) break;

            ListNode nextGroupStart = KthNode.next;
            KthNode.next = null; // Disconnect the kth node to separate the group
            ListNode reversedGroupHead = reverse(temp); // Reverse the current group

            if (prevGroupEnd == null) // If it's the first group, update the head
                head = reversedGroupHead;
            else // If it's not the first group, link the previous group's end to the current group's head
                prevGroupEnd.next = reversedGroupHead;

            temp.next = nextGroupStart; // Link the current group's end to the next group's start
            prevGroupEnd = temp; // Update the end of the previous group
            temp = nextGroupStart; // Move temp to the start of the next group
        }

        return head;
    }

    public static ListNode findKNode(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;
        while (count < k && temp != null && temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count == k ? temp : null;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode before = null;
        ListNode temp = head;
        ListNode after;

        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}
