
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

        // Heap h = new Heap();
        // h.add(4);
        // h.add(2);
        // h.add(5);
        // h.add(1);
        // h.add(0);

        // while (!h.isEmpty()) {
        // System.out.println(h.peek());
        // h.delete();
        // }

        /// Heap Sort Algorithm
        // int arr[] = { 2, 4, 1, 7, 3, 5 };
        // heapSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        /// Finding Nearest points from origin with Priority Queues
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int points[][] = {
        // { 3, 3 },
        // { 5, -1 },
        // { -2, 4 }
        // };
        // int k = 2;

        // for (int i = 0; i < points.length; i++) {
        // pq.add(
        // points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        // }

        // while (k > 0) {
        // System.out.println(pq.peek());
        // pq.remove();
        // k--;
        // }

        /// Connecting Ropes Problem
        // int arr[] = { 2, 3, 3, 4, 6 };
        // int totalSum = 0;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int i = 0; i < arr.length; i++) {
        // pq.add(arr[i]);
        // }

        // while (pq.size() > 1) {
        // int val1 = pq.remove();
        // int val2 = pq.remove();

        // pq.add(val1 + val2);
        // totalSum += (val1 + val2);
        // }
        // System.out.println(totalSum);

        // int arm[][] = {
        // { 1, 0, 0, 0 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 }
        // };
        // PriorityQueue<Row> pq = new PriorityQueue<>();
        // for (int i = 0; i < arm.length; i++) {
        // int totalSol = 0;
        // for (int j = 0; j < arm[i].length; j++) {
        // if (arm[i][j] == 1) {
        // totalSol++;
        // }
        // }
        // pq.add(new Row(i, totalSol));
        // }

        // System.out.println(pq.remove().index);
        // System.out.println(pq.remove().index);

        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int result[] = maxSlidingWindow(nums, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || k == 0) {
            return nums;
        }
        int arr[] = new int[nums.length - (k - 1)];
        PriorityQueue<PQ> pq = new PriorityQueue<>();
        int si = 0;
        int ei = k - 1;
        int index = 0;

        for (int i = 0; i < k; i++) {
            pq.add(new PQ(i, nums[i]));
        }
        arr[index] = pq.peek().value;
        index++;
        si++;
        ei++;

        while (!pq.isEmpty() && ei < nums.length) {
            if (pq.peek().index < si) {
                pq.remove();
            } else {
                pq.add(new PQ(ei, nums[ei]));
                arr[index] = pq.peek().value;
                si++;
                ei++;
                index++;
            }
        }

        return arr;
    }

    static class PQ implements Comparable<PQ> {
        int index;
        int value;

        PQ(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(PQ pq) {
            return pq.value - value;
        }
    }

    static class Row implements Comparable<Row> {
        int index;
        int soldierCount;

        Row(int index, int soldierCount) {
            this.index = index;
            this.soldierCount = soldierCount;
        }

        @Override
        public int compareTo(Row r) {
            if (soldierCount != r.soldierCount) {
                return soldierCount - r.soldierCount;
            } else {
                return index - r.index;
            }
        }
    }

    public static void heapSort(int arr[]) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int i = arr.length - 1;
        while (i > 0) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            heapify(arr, 0, i);
            i--;
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;
        if (left < size && arr[left] < arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] < arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            int t = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = t;
            heapify(arr, maxIndex, size);
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
            int index = rootIndex;

            if (left < arr.size() && arr.get(index) > arr.get(left)) {
                index = left;
            }

            if (right < arr.size() && arr.get(index) > arr.get(right)) {
                index = right;
            }

            if (index != rootIndex) {
                int temp = arr.get(rootIndex);
                arr.set(rootIndex, arr.get(index));
                arr.set(index, temp);
                heapify(index);
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