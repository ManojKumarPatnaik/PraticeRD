package rough;

import java.util.Arrays;

public class SortingAlgo {
    public static void main(String[] args) {
        int A[] = {9, 8, 7, 5, 3, 2, 1, 1};
        quickSortHelper(A);
//        System.out.println(Arrays.toString(mergeSort(A)));
        System.out.println(Arrays.toString(A));
    }

    public static void quickSortHelper(int[] A) {
        quickAlgo(A, 0, A.length - 1);
    }

    private static void quickAlgo(int[] a, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(a, left, right);
            quickAlgo(a, left, pivotIndex - 1);
            quickAlgo(a, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] a, int pivotIndex, int right) {
        int swapIndex = pivotIndex;
        for (int j = pivotIndex + 1; j <= right; j++) {
            if (a[j] < a[pivotIndex]) {
                swapIndex++;
                privateSwap(a, swapIndex, j);
            }
        }
        privateSwap(a, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static int[] mergeSort(int A[]) {
        int l = A.length;
        if (l == 1) return A;
        int midIndex = l / 2;
        int[] left = mergeSort(Arrays.copyOfRange(A, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(A, midIndex, l));
        return merge(left, right);
    }

    public static int[] merge(int[] A1, int[] A2) {
        int al = A1.length, al1 = A2.length;
        int[] res = new int[al + al1];
        int ind = 0, i = 0, j = 0;
        while (i < al && j < al1) {
            if (A1[i] < A2[j]) {
                res[ind++] = A1[i++];
            } else {
                res[ind++] = A2[j++];
            }
        }
        while (i < al) {
            res[ind++] = A1[i++];
        }
        while (j < al1) {
            res[ind++] = A2[j++];
        }
        return res;
    }

    public static void insertionSort(int A[]) {
        for (int i = 1; i < A.length; i++) {
            int j = i - 1, tem = A[i];
            while (j > -1 && tem < A[j]) {
                A[j + 1] = A[j];
                A[j] = tem;
                j--;
            }

        }
    }

    public static void selectionSort(int A[]) {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) privateSwap(A, minIndex, i);
        }
    }

    public static void bubbleSort(int A[]) {
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    privateSwap(A, j, j + 1);
                }
            }
        }
    }

    private static void privateSwap(int[] A, int j, int i) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}
