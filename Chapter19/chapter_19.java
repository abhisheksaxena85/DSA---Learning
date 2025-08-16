
/*
    Starting Heaps/Priority Queues
    Start Date - Aug 15 2025, 05:45 PM
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

class chapter_19 {
    public static void main(String arg[]) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // pq.add(new Student("A", 12));
        // pq.add(new Student("C", 1));
        // pq.add(new Student("D", 2));
        // System.out.println(pq.peek().name + " -- " + pq.peek().rank);

        Heap h = new Heap();
        h.add(4);
        h.add(2);
        h.add(5);
        h.add(1);
        h.add(0);

        System.out.println(h.peek());
    }

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // par index
            while (arr.get(x) < arr.get(par)) {
                // 0(logn) swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }
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