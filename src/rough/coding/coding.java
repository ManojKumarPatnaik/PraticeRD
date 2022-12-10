package rough.coding;

import java.util.Arrays;
import java.util.HashMap;

public class coding {
    /*
    Time Complexity: O( N * N * M )
    Space Complexity: O( N * M )

    where N denotes the number of countries and M denotes the number of months

*/
    public class Solution {
        static int daysToEnjoyHelper(int i, int j, int[][] dp, int[][] restriction, int[][] teleport) {
            // Base condition (intial month)
            if (j == 0) {
                return dp[i][0];
            }
            // Memoization
            if (dp[i][j] != Integer.MIN_VALUE) {
                return dp[i][j];
            }
            // Find the countries that we can visit in the previous month
            for (int prev = 0; prev < teleport.length; prev++) {
                // If the previous country is same as the current country or if teleport(prev->i) is possible
                if (prev == i || teleport[prev][i] == 1) {
                    // Recursive call to calculate dp[prev][j-1]
                    dp[i][j] = Math.max(daysToEnjoyHelper(prev, j - 1, dp, restriction, teleport), dp[i][j]);
                }
            }

            // Add the days we can enjoy in the j'th month
            dp[i][j] += restriction[i][j];
            // Return the calculated value of dp[i][j]
            return dp[i][j];
        }


        static int daysToEnjoy(int n, int m, int[][] restriction, int[][] teleport) {
            int dp[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
            for (int i = 0; i < n; i++) {
                if (teleport[0][i] > 0) {
                    dp[i][0] = restriction[i][0];
                }
            }
            dp[0][0] = restriction[0][0];
            // Variable to store the maximum days we can enjoy
            int mxDays = 0;
            // Inital recursive calls to each country we visit in the last month
            for (int i = 0; i < n; i++) {
                mxDays = Math.max(mxDays, daysToEnjoyHelper(i, m - 1, dp, restriction, teleport));
            }
            // Finally, return the optimal answer calculated
            return mxDays;
        }
    }

    /*
    Time Complexity: O( N * N * M )
    Space Complexity: O( N * M )

    where N denotes the number of countries and M denotes the number of months
*/
    public class Solution1 {
        public static int help(int i, int j, int[][] dp, int[][] R, int[][] T) {
            if (j == 0) {
                return dp[i][0];
            }
            if (dp[i][j] != Integer.MIN_VALUE) {
                return dp[i][j];
            }
            for (int p = 0; p < T.length; p++) {
                if (p == i || T[p][i] == 1) {
                    dp[i][j] = Math.max(help(p, j - 1, dp, R, T), dp[i][j]);
                }
            }
            dp[i][j] += R[i][j];
            return dp[i][j];
        }

        public static int daysToEnjoy(int N, int M, int[][] R, int[][] T) {
            int[][] dp = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < M; i++) {
                    dp[j][i] = Integer.MIN_VALUE;
                }
            }
            for (int i = 0; i < N; i++) {
                if (T[0][i] > 0) dp[i][0] = R[i][0];
            }
            dp[0][0] = R[0][0];
            int m = 0;
            for (int i = 0; i < N; i++) {
                m = Math.max(m, help(i, M - 1, dp, R, T));
            }
            return m;
        }
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        var mp=new HashMap<String,Object>();
        mp.put("1",1);
        mp.put("1",3);
        System.out.println(mp);
        String sd="manoj.kdnjd.sj";
        int x = sd.indexOf(".");
        System.out.println(sd.substring(0,x));

        int daysToEnjoy = Solution1.daysToEnjoy(3, 5, new int[][]{
                {0, 0, 0, 0, 30},
                {10, 10, 10, 10, 0},
                {20, 20, 20, 20, 0}
        }, new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 0}});
        System.out.println(daysToEnjoy);
    }


}
