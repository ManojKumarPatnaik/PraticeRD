package rough;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static int[] A = {9, 8, 7, 5, 4, 3, 2, 1, 0};

    public static void quickSort(int low, int high) {
        if (low >= high) return;
        int pivotIndex = new Random().nextInt(high-low)+low;
        int pivot = A[pivotIndex];
        swap(A,pivotIndex,high);
        int mid = partition(low, high,pivot);
        quickSort(low, mid - 1);
        quickSort(mid + 1, high);
    }

    public static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    private static int partition(int low, int high, int pivot) {
        int left = low,right=high;
        while(left<right){
            while (A[left]<=pivot && left<right){
                left++;
            }
            while (A[right]>=pivot && left<right){
                right--;
            }
            swap(A,left,right);
        }
        swap(A,left,high);

        return left;
    }

    public static void main(String[] args) {

        System.out.println("Before"+Arrays.toString(A));
        quickSort(0, A.length-1);
        System.out.println(Arrays.toString(A));
    }
}
