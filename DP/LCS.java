/*
Problem Statement : Given two strings string1 and string2, return the length of their 
                    longest common subsequence. 
                    If there is no common subsequence, return 0.
Input: string1 = "abcde", string2 = "ace" 
Output: 3  
*/

import java.util.*;
class LCS
{
    public static int LCS1(String s1, String s2, int m, int n, int dp[][])
    {
        // This is recursive top-down approach   ---> TC : O(mn) , SC : O(mn)
        if(m==0 || n==0)
           return 0;
        if(dp[m][n] != -1)
           return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1))
           return dp[m][n] = 1 + LCS1(s1, s2, m-1, n-1, dp);
        else
           return dp[m][n] = Math.max(LCS1(s1, s2, m-1, n, dp), LCS1(s1, s2, m, n-1, dp));
    }

    public static int LCS2(String s1, String s2, int m, int n)
    {
        // This is iterative bottom-up approach   ---> TC : O(mn) , SC : O(mn)
        if(m==0 || n==0)
            return 0;
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                   dp[i][j] = 1 + dp[i-1][j-1];
                else
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }

    public static int LCS3(String s1, String s2, int m, int n)
    {
        // This is iterative bottom-up approach, which is space optimized   ---> TC : O(mn) , SC : O(n)
        if(m==0 || n==0)
           return 0;
        int dp[] = new int[n+1];

        for(int i=1; i<=m; i++)
        {
            int prev = 0;
            for(int j=1; j<=n; j++)
            {
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j-1]);
                prev = temp;
            }
        }

        return dp[n];
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two strings:");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                dp[i][j] = -1;
            }
        }
        System.out.println("Length of LCS: " + LCS1(s1, s2, s1.length(), s2.length(), dp));
        System.out.println("Length of LCS: " + LCS2(s1, s2, s1.length(), s2.length()));
        System.out.println("Length of LCS: " + LCS3(s1, s2, s1.length(), s2.length()));
    }
}