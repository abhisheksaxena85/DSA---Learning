
/*
    Starting Heaps/Priority Queues
    Start Date - Aug 15 2025, 05:45 PM
 */
import java.util.Comparator;
import java.util.PriorityQueue;

class chapter_19 {
    public static void main(String arg[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(1);
        pq.add(4);
        pq.add(11);
        System.out.println(pq.peek());
    }
}