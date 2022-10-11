package Sprint_3.K_StupidDescription;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int k = left;
        int[] leftBuf = Arrays.copyOfRange(arr, left, mid);
        int[] rightBuf = Arrays.copyOfRange(arr, mid, right);
        int l = 0;
        int r = 0;
        while (l < leftBuf.length && r < rightBuf.length) {
            if (leftBuf[l] <= rightBuf[r]) {
                arr[k] = leftBuf[l];
                l++;
            } else {
                arr[k] = rightBuf[r];
                r++;
            }
            k++;
        }
        while (l < leftBuf.length) {
            arr[k] = leftBuf[l];
            l++;
            k++;
        }
        while (r < rightBuf.length) {
            arr[k] = rightBuf[r];
            r++;
            k++;
        }
        return arr;
    }

    public static void merge_sort(int[] a, int left, int right) {
        if (right - left < 2)
            return;
        int mid = left + (right - left) / 2;
        merge_sort(a, left, mid);
        merge_sort(a, mid, right);

        merge(a, left, mid, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 4, 10, 11};
        int[] b = merge(arr, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert Arrays.equals(c, expected2);
    }
}
