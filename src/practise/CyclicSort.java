package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
        int[] ints = {1, 2, 13, 4, 13, 5};
//        cyclicSort(ints);
        System.out.println(findAllIndexes2(ints, 13, 0));
        System.out.println(rotatedBS(new int[]{1, 2, 13, 4, 3, 2}, 13, 0, 5));
        boolean sortedArray = sortedArray(ints, 0);
        System.out.println(sortedArray);
        System.out.println(Arrays.toString(ints));
        System.out.println(reverseLL(1234));
        int x = (int) Math.log10(1234) + 1;
//        System.out.println(x);
//        System.out.println(reverseLL2(1234,x));
//        System.out.println(count(12300004,0));
//        System.out.println(devidEvenOrSubtractOdd(14,0));
        int[][] G = {
                {1, 3, 5},
                {2, 1, 2},
                {4, 3, 1}
        };
        System.out.println(minimumCost(G));
        for (int i = 0; i < G.length; i++) {
            Arrays.fill(G[i], -1);
        }
        System.out.println(Arrays.deepToString(G));
        System.out.println();
        triangle(4, 0);
        int A[] = {9, 8, 7, 5, 4, 2, 1};
//        selection(A,A.length,0,0);
        quickSort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));

    }

    static void triangle(int r, int c) {
        if (r == 0) return;
        if (r > c) {
            System.out.print("*");
            triangle(r, c + 1);
        } else {
            System.out.println();
            triangle(r - 1, 0);
        }
    }

    static void bubble(int A[], int r, int c) {
        if (r == 0) return;
        if (r > c) {
            if (A[c] > A[c + 1]) {
                int t = A[c];
                A[c] = A[c + 1];
                A[c + 1] = t;
            }
            bubble(A, r, c + 1);
        } else {
            bubble(A, r - 1, 0);
        }
    }

    static void selection(int A[], int r, int c, int max) {
        if (r == 0) return;
        if (r > c) {
            if (A[c] > A[max]) {
                selection(A, r, c + 1, c);
            } else
                selection(A, r, c + 1, max);
        } else {
            int t = A[max];
            A[max] = A[r - 1];
            A[r - 1] = t;
            selection(A, r - 1, 0, 0);
        }
    }

    static int[] mergeSort(int A[]) {
        int length = A.length;
        if (length == 1) return A;
        int mid = length / 2;
        int first[] = mergeSort(Arrays.copyOfRange(A, 0, mid));
        int second[] = mergeSort(Arrays.copyOfRange(A, mid, length));
        return merge(first, second);
    }

    private static int[] merge(int[] first, int[] second) {
        int l1 = first.length, l2 = second.length, i = 0, j = 0, k = 0;
        int A[] = new int[l1 + l2];
        while (i < l1 && j < l2) {
            if (first[i] < second[j]) {
                A[k] = first[i++];
            } else A[k] = second[j++];
            k++;
        }
        while (i < l1) {
            A[k++] = first[i++];
        }
        while (j < l1) {
            A[k++] = first[j++];
        }
        return A;
    }

    static void quickSort(int[] A, int low,int high) {
        if(low>=high) return;
        int s=low;
        int e=high;
        int mid=low+(high-low)/2;
        int pivot=A[mid];
        while(s<=e){
            while(A[s]<pivot)s++;
            while(A[e]>pivot)e--;
            if(s<=e){
                int t=A[s];
                A[s] = A[e];
                A[e] = t;
                s++;
                e--;
            }
        }
        quickSort(A,low,e);
        quickSort(A,s,high);
    }

    static void mergeSortInplace(int A[], int s, int e) {
        int length = e - s;
        if (length == 1) return;
        int mid = (s + e) / 2;
        mergeSortInplace(A, 0, mid);
        mergeSortInplace(A, mid, e);
        mergeInplace(A, s, mid, e);
    }

    private static void mergeInplace(int[] array, int s, int mid, int e) {
        int l1 = mid, l2 = e, i = s, j = mid, k = 0;
        int result[] = new int[e - s];
        while (i < l1 && j < l2) {
            if (array[i] < array[j]) {
                result[k] = array[i++];
            } else result[k] = array[j++];
            k++;
        }
        while (i < l1) {
            result[k++] = array[i++];
        }
        while (j < l2) {
            result[k++] = array[j++];
        }
        for (int l = 0; l < result.length; l++) {
            array[s + l] = result[l];
        }
    }

    static int minimumCost(int[][] G) {

        int R = G.length, C = G[0].length;
        if (R == 0) return 0;
        int[][] dp = new int[R][C];
        dp[0][0] = G[0][0];
        for (int i = 1; i < C; i++)
            dp[0][i] = dp[0][i - 1] + G[0][i];
        for (int i = 1; i < R; i++)
            dp[i][0] = dp[i - 1][0] + G[i][0];

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                dp[i][j] = G[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[R - 1][C - 1];

    }

    static int rotatedBS(int[] ints, int t, int s, int e) {
        if (s > e) return -1;
        int m = s + (e - s) / 2;
        if (ints[m] == t) {
            return m;
        }
        if (ints[s] <= ints[m]) {
            if (t >= ints[s] && t <= ints[m]) {
                return rotatedBS(ints, t, s, m - 1);
            } else {
                return rotatedBS(ints, t, m + 1, e);
            }
        }
        if (t >= ints[m] && t <= ints[e]) {
            return rotatedBS(ints, t, m + 1, e);
        }
        return rotatedBS(ints, t, s, m - 1);
    }

    static List findAllIndexes(int[] ints, int target, int index, List<Integer> integerList) {
        if (index == ints.length - 1) return integerList;
        if (ints[index] == target) integerList.add(index);
        return findAllIndexes(ints, target, index + 1, integerList);
    }

    static List findAllIndexes2(int[] ints, int target, int index) {
        List<Integer> integerList = new ArrayList<Integer>();
        if (index == ints.length - 1) return integerList;
        if (ints[index] == target) integerList.add(index);
        List<Integer> integerList1 = findAllIndexes2(ints, target, index + 1);
        integerList.addAll(integerList1);
        return integerList;
    }

    static boolean sortedArray(int[] ints, int index) {
        if (ints.length - 1 == index) return true;
        return ints[index] < ints[index + 1] && sortedArray(ints, index + 1);
    }

    static int devidEvenOrSubtractOdd(int ints, int steps) {
        if (ints == 0) return steps;
        if (ints % 2 == 0) return devidEvenOrSubtractOdd(ints / 2, steps + 1);
        return devidEvenOrSubtractOdd(ints - 1, steps + 1);
    }

    static int count(int ints, int base) {
        if (ints == 0) return base;
        int ints1 = ints % 10;
        if (ints1 == 0) ++base;
        return count(ints / 10, base);
    }

    static int reverseLL2(int n, int digit) {
        if (n % 10 == n) return n;
        return (n % 10) * (int) Math.pow(10, digit - 1) + reverseLL2(n / 10, digit - 1);
    }

    static int r = 0;

    static int reverseLL(int n) {
        if (n == 0) return n;
        r = r * 10 + n % 10;
        reverseLL(n / 10);
        return r;
    }

    static int sum(int n) {
        if (n == 0) return 0;
        return n % 10 + sum(n / 10);
    }

    static void cyclicSort(int A[]) {
        int i = 0;
        while (i < A.length) {
            int crtInd = A[i] - 1;
            if (A[i] != A[crtInd]) {
                swap(A, i, crtInd);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
