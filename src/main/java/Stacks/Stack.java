package Stacks;

public class Stack {

    private Node top;
    private int height;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    public void push(int value){
        Node node = new Node(value);
        node.next = top;
        top = node;
        height++;
    }

    public Node pop(){
        if (height == 0){
            return null;
        }
        Node temp = top;
        top = top.next;
        height--;
        temp.next = null;
        return temp;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }
}
