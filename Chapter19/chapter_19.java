
/*
    Starting Heaps/Priority Queues
    Start Date - Aug 15 2025, 05:45 PM
 */
import java.util.Comparator;
import java.util.PriorityQueue;

class chapter_19 {
    public static void main(String arg[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 12));
        pq.add(new Student("C", 1));
        pq.add(new Student("D", 2));
        System.out.println(pq.peek().name + " -- " + pq.peek().rank);
    }

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student student) {
            return rank - student.rank;
        }
    }
}