
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

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.delete();
        }
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

        public void delete() {
            // step - 1 : swap root node with last in arr
            // int temp = arr.get(arr.size() - 1);
            // arr.set(arr.size() - 1, arr.get(0));
            // arr.set(0, temp);

            // step - 2 : Delete the last node
            arr.remove(0);

            // call the heapify to fix the CBT
            heapify(0);
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }

        private void heapify(int rootIndex) {
            int left = (2 * rootIndex) + 1;
            int right = (2 * rootIndex) + 2;

            if (left < arr.size() && arr.get(rootIndex) > arr.get(left)) {
                int temp = arr.get(rootIndex);
                arr.set(rootIndex, arr.get(left));
                arr.set(left, temp);
                heapify(left);
            }

            if (right < arr.size() && arr.get(rootIndex) > arr.get(right)) {
                int temp = arr.get(rootIndex);
                arr.set(rootIndex, arr.get(right));
                arr.set(right, temp);
                heapify(right);
            }

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