package Sprint_5.M;

public class Solution {
    public static int siftUp(int[] heap, int idx) {
        while (true) {
            int parent = idx / 2;
            if (parent < 1) {
                break;
            }
            if (heap[idx] > heap[parent]) {
                int temp = heap[parent];
                heap[parent] = heap[idx];
                heap[idx] = temp;
                idx = parent;
            } else {
                break;
            }
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }
}
