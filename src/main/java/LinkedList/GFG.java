package LinkedList;

class GfG
{

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private static int getPalindromeLength(Node left, Node right) {
        int length = 0;
        while (left != null && right != null && left.value == right.value) {
            length += 2; // Increment length by 2 for each matching pair
            left = left.next;
            right = right.next;
        }
        return length;
    }

    public static int maxPalindrome(Node head)
    {
        if (head == null)
            return 0;

        int maxLength = 0;
        Node current = head;

        while (current != null) {
            // Odd length palindrome
            int oddLength = getPalindromeLength(current, current);
            // Even length palindrome
            int evenLength = getPalindromeLength(current, current.next);

            // Update maxLength
            maxLength = Math.max(maxLength, Math.max(oddLength, evenLength));

            // Move to the next node
            current = current.next;
        }

        return maxLength;
    }

}
