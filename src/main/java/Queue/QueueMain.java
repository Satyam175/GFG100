package Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        System.out.println("========");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}
