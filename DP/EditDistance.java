/*
Problem Statement : Given two strings A and B,find minimum number of edits (operations) 
                    required to convert ‘A’ into ‘B’.  Operations that can be performed -
                    Insert, Remove, Replace

Input:   A = "sunday", B = "saturday"
Output:  3
*/

import java.util.*;
class EditDistance
{
    public static int editDist(String A, String B, int m, int n, int dp[][])
    {
        // This is recursive top-down approach with memorization  ---> TC : O(mn) , SC : O(mn)
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(A.charAt(m-1) == B.charAt(n-1))
            return dp[m][n] = editDist(A, B, m-1, n-1, dp);
        else
            {
                int a = editDist(A, B, m, n-1, dp);   //Insert
                int b = editDist(A, B, m-1, n, dp);   //Delete
                int c = editDist(A, B, m-1, n-1, dp); //Replace
                return dp[m][n] = 1 + Math.min(a,Math.min(b,c));
            }
    }

    public static int editDist2(String A, String B, int m, int n)
    {
        // This is iterative bottom-up approach   ---> TC : O(mn) , SC : O(mn)
        if(m == 0)
           return n;
        if(n ==0)
           return m;
        
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n ;j++)
            {
                if(i==0)
                   dp[i][j] = j;
                else if(j ==0)
                   dp[i][j] = i;
                else if(A.charAt(i-1) == B.charAt(j-1))
                   dp[i][j] = dp[i-1][j-1];
                else
                   dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])); 
            }
        }
        return dp[m][n];
    }

    public static int editDist3(String A, String B, int m, int n)
    {
        // This is iterative bottom-up approach, which is space optimized   ---> TC : O(mn) , SC : O(n)
        if(m == 0)
           return n;
        if(n ==0)
           return m;

        int dp[] = new int[n+1];
        for(int i=0; i<=n; i++)
        {
            dp[i] = i;
        }
        int prev = 0;
        for(int i=1; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                int temp = dp[j];
                if(j == 0)
                   dp[j] = i;
                else if(A.charAt(i-1) == B.charAt(j-1))
                   dp[j] = prev;
                else
                   dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], prev));
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
        System.out.println("Length of Edit Dist: " + editDist(s1, s2, m, n, dp));
        System.out.println("Length of Edit Dist: " + editDist2(s1, s2, m, n));
        System.out.println("Length of Edit Dist: " + editDist3(s1, s2, m, n));
    }
}