package LinkedList;

public class ReverseII {
    static class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Node five = new Node(5);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node head = new Node(1, two);

        Node newHead = reverseBetween(head, 2, 4);

    }

    public static Node reverseBetween(Node head, int left, int right) {
        if(right == 1) return head;

        int currentPos = 1;
        Node currentNode = head;
        Node start = head;
        while(currentPos < left){
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }

        Node newList = null;
        Node tail = currentNode;

        while(currentPos >= left && currentPos <= right){
            Node next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPos++;
        }

        start.next = newList;
        tail.next = currentNode;

        if(left > 1) return head;
        return newList;

    }
}
