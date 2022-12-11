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
//        quickSort(A, 0, A.length-1);
//        System.out.println(Arrays.toString(A));
//        String baaccadh = skipApple("baacapplecadh");
//        System.out.println(baaccadh);
//        subsequence("","abcd");
//        System.out.println(subsequence1("","abcd"));
//        System.out.println(subsequence2("","abcd",new ArrayList()));
//        int Ans[]={1,2,2};
//        var ans=subSetsDuplicate(Ans);
//        ans.forEach(System.out::println);
//        System.out.println();
        ArrayList permutationRet = permutationRet("", "abc");
        System.out.println(permutationRet);
        System.out.println(phonePad("","12"));
        System.out.println(dice("",4));
        System.out.println(directions("",3,3));
        boolean[][] B={
                {true,true,true},{true,true,true},{true,true,true}
        };
        int path[][]=new int[B.length][B[0].length];
        System.out.println(allPossiblePaths(B,"",0,0,path,1));
        System.out.println(noOfWaysNQueens(new boolean[4][4],0));
        System.out.println(isHappy(19));

    }

    static boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do{
            slow=slove(slow);
            fast=slove(slove(fast));
        }while (slow!=fast);
        return slow==1;
    }
    static int slove(int n){
        int ans=0;
        while(n>0){
            int re=n%10;
            ans+=re*re;
            n/=10;
        }return ans;
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

    static ArrayList directions(String p,int r, int c) {
        if (r == 1 && c==1) {
            var l= new ArrayList();
            l.add(p);
            return l;
        }
        var l= new ArrayList();
        if (r > 1) {
           l.addAll( directions(p+'D', r - 1, c));
        } if(c>1) {
           l.addAll(directions(p+'R', r, c - 1));
        }
        if(c>1 && c>1) {
            l.addAll(directions(p+'d', r-1, c - 1));
        }
        return l;
    }

    static ArrayList directionsWithRestriction(boolean[][] B, String p,int r, int c) {
        int row=B.length-1,clm=B[0].length-1;
        if (r == row && c==clm) {
            var l= new ArrayList();
            l.add(p);
            return l;
        }
        if(!B[r][c]) return new ArrayList<>();
        var l= new ArrayList();
        if (r <row) {
            l.addAll( directionsWithRestriction(B,p+'D', r + 1, c));
        } if(c<clm) {
            l.addAll(directionsWithRestriction(B,p+'R', r, c +1));
        }
        return l;
    }

    static ArrayList directionsWithAll(boolean[][] B, String p,int r, int c) {
        int row=B.length-1,clm=B[0].length-1;
        if (r == row && c==clm) {
            var l= new ArrayList();
            l.add(p);
            return l;
        }
        if(!B[r][c]) return new ArrayList<>();
        B[r][c]=false;
        var l= new ArrayList();
        if (r <row) {
            l.addAll( directionsWithAll(B,p+'D', r + 1, c));
        } if(c<clm) {
            l.addAll(directionsWithAll(B,p+'R', r, c +1));
        }if(r>0){
            l.addAll(directionsWithAll(B,p+'U',r-1,c));
        }if(c>0){
            l.addAll(directionsWithAll(B,p+'L',r,c-1));
        }

        B[r][c]=true;
        return l;
    }

    static ArrayList allPossiblePaths(boolean[][] B, String p,int r, int c,int[][] path,int step) {
        int row=B.length-1,clm=B[0].length-1;
        if (r == row && c==clm) {
            var l= new ArrayList();
            l.add(p);
           for(var v:path){
               System.out.println(Arrays.toString(v));
           }
            System.out.println();
            System.out.println(p);
            return l;
        }
        if(!B[r][c]) return new ArrayList<>();
        B[r][c]=false;
        path[r][c]=step;
        var l= new ArrayList();
        if (r <row) {
            l.addAll( allPossiblePaths(B,p+'D', r + 1, c,path,step+1));
        } if(c<clm) {
            l.addAll(allPossiblePaths(B,p+'R', r, c +1,path,step+1));
        }if(r>0){
            l.addAll(allPossiblePaths(B,p+'U',r-1,c,path,step+1));
        }if(c>0){
            l.addAll(allPossiblePaths(B,p+'L',r,c-1,path,step+1));
        }

        B[r][c]=true;
        path[r][c]=0;
        return l;
    }

    static int noOfWaysNQueens(boolean[][] Q,int row){
        if(row==Q.length){
            display(Q);
            System.out.println();
            return 1;
        }int count=0;

        for (int i = 0; i < Q.length; i++) {
            if(isSafe(Q,row,i)){
                Q[row][i]=true;
                count+=noOfWaysNQueens(Q,row+1);
                Q[row][i]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] q, int row, int i) {
        //vertical order
        for (int j = 0; j < row; j++) {
            if(q[j][i])return false;
        }
        //diagonal order
        int maxLeft=Math.min(row,i);
        for (int j = 1; j <= maxLeft; j++) {
            if(q[row-j][i-j]) return false;
        }
        //diagonal order
        int maxRight=Math.min(row,q.length-1-i);
        for (int j = 1; j <= maxRight; j++) {
            if(q[row-j][i+j]) return false;
        }
        return true;
    }

    private static void display(boolean[][] q) {
        for(var v:q){
            for(var i:v){
                if(i)
                System.out.print("Q");
                else System.out.print("X");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> subSets(int A[]){
        var outerList = new ArrayList<List<Integer>>();
        outerList.add(new ArrayList<>());
        for(var v:A){
            int n=outerList.size();
            for (int i = 0; i < n; i++) {
                var internal = new ArrayList<>(outerList.get(i));
                internal.add(v);
                outerList.add(internal);
            }
        }
        return outerList;
    }

    static List<List<Integer>> subSetsDuplicate(int A[]){
        var outerList = new ArrayList<List<Integer>>();
        outerList.add(new ArrayList<>());
        int start=0;
        int end=0;
        for (int i = 0; i < A.length; i++) {
            if(i>0 && A[i]==A[i-1]){
                start=1+end;
            }
        end=outerList.size()-1;
            int n=outerList.size();
            for (int j = start; j < n; j++) {
                var internal = new ArrayList<>(outerList.get(j));
                internal.add(A[i]);
                outerList.add(internal);
            }
        }
        return outerList;
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

    static void subsequence(String p,String up){
        if(up.isBlank()) {
            System.out.println(p);
            return;
        }
        char c= up.charAt(0);
        subsequence(p,up.substring(1));
        subsequence(c+p,up.substring(1));
    }
    static void permutations(String p,String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char c= up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0,i);
            String t = p.substring(i);
            permutations(s+c+t,up.substring(1));
        }
    }

    static ArrayList permutationRet(String p,String up){
        if(up.isEmpty()) {
            var in=new ArrayList();
            in.add(p);
            return in;
        }
        char c= up.charAt(0);
        var out= new ArrayList();
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0,i);
            String t = p.substring(i);
            out.addAll(permutationRet(s+c+t,up.substring(1)));
        }return out;
    }


    static ArrayList phonePad(String p,String up){
        if(up.isEmpty()) {
            var in=new ArrayList();
            in.add(p);
            return in;
        }
        int digit = up.charAt(0)-'0';
        var out= new ArrayList();
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char c= (char)('a'+i);
            out.addAll(phonePad(p+c,up.substring(1)));
        }return out;
    }

    static ArrayList dice(String p,int t){
        if(t==0) {
            var in=new ArrayList();
            in.add(p);
            return in;
        }
        var out= new ArrayList();
        for (int i = 1; i <=6 && i<=t; i++) {
            out.addAll(dice(p+i,t-i));
        }return out;
    }


    static int mazeCountNoOfWays(int r,int c){
        if(r==1||c==1) {
            return 1;
        }
        var out= mazeCountNoOfWays(r-1,c);
        var in= mazeCountNoOfWays(r,c-1);
        return out+in;
    }

    static ArrayList subsequence1(String p,String up){
        if(up.isBlank()) {
            System.out.println(p);
            ArrayList l = new ArrayList();
            l.add(p);
            return l;
        }
        char c= up.charAt(0);
        var le=subsequence1(p,up.substring(1));
        var r=subsequence1(c+p,up.substring(1));
        r.addAll(le);
        return r;
    }

    static ArrayList subsequence2(String p,String up,ArrayList l){
        if(up.isBlank()) {
            l.add(p);
            return l;
        }
        char c= up.charAt(0);
        subsequence2(p,up.substring(1),l);
        subsequence2(c+p,up.substring(1),l);
        return l;
    }

    static String skip2(String up){
        if(up.isBlank()) {
            return "";
        }
        char c= up.charAt(0);
        if(c=='a'){
          return   skip2(up.substring(1));
        }else  return  c+skip2(up.substring(1));
    }

    static String skipApple(String up){
        if(up.isBlank()) {
            return "";
        }
        if(up.startsWith("apple")){
            return   skipApple(up.substring(5));
        }else  return  up.charAt(0)+skipApple(up.substring(1));
    }

    static void skip(String p,String up){
        if(up.isBlank()) {
            System.out.println(p);
            return;
        }
        char c= up.charAt(0);
        if(c=='a'){
            skip(p,up.substring(1));
        }else skip(c+p,up.substring(1));
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
