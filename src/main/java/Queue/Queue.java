package Queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Queue(int value) {
        Node node = new Node(value);
        first = node;
        last = node;
        length++;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (length == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0){
            return null;
        }
        Node temp = first;
        if (length == 1){
            first = null;
            last = null;
        }else {
            first = temp.next;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getFirst() {
        return first.value;
    }

    public int getLast() {
        return last.value;
    }

    public int getLength() {
        return length;
    }
}
