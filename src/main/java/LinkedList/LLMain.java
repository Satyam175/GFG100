package LinkedList;

import Queue.Queue;

import java.util.Deque;

public class LLMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(8);
        linkedList.printList();
//        System.out.println(linkedList.getMiddleNode().value);
        linkedList.reverse(linkedList.getHead());
        linkedList.printList();
//
//        System.out.println(linkedList.removeLast().value);
//        System.out.println(linkedList.removeLast().value);
//        linkedList.printList();
//        linkedList.append(10);
//        linkedList.printList();

    }


}
