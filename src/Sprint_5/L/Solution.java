package Sprint_5.L;

public class Solution {
    public static int siftDown(int[] heap, int idx) {
        while (true) {

            int left = idx * 2;
            int right = idx * 2 + 1;
            if (left > heap.length - 1 && right > heap.length - 1) {
                break;
            }
            if (left <= heap.length - 1 && right <= heap.length - 1) {
                if (heap[idx] < heap[left] || heap[idx] < heap[right]) {
                    int temp = heap[idx];
                    if (heap[left] > heap[right]) {
                        heap[idx] = heap[left];
                        heap[left] = temp;
                        idx = left;
                    } else {
                        heap[idx] = heap[right];
                        heap[right] = temp;
                        idx = right;
                    }
                } else {
                    break;
                }
            } else if (left > heap.length - 1) {
                if (heap[idx] < heap[right]) {
                    int temp = heap[idx];
                    heap[idx] = heap[right];
                    heap[right] = temp;
                    idx = right;
                } else {
                    break;
                }
            } else if (right > heap.length - 1) {
                if (heap[idx] < heap[left]) {
                    int temp = heap[idx];
                    heap[idx] = heap[left];
                    heap[left] = temp;
                    idx = left;
                } else {
                    break;
                }
            }
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}
