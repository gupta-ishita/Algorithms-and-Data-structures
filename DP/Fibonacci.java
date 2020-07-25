/*
Problem Statement : Given the value of n, find the nth term of fibonacci series  [1,1,2,3,5,8,13,21,..]

Input : 3
Output : 2
*/


import java.util.*;
class Fibonacci
{
    public static long fibTopDown(int n, long dp[])
    {
        // This is the recursive approach with memorization  --- TC : O(n) ,  SC : O(n)
        
        if(n==0 || n==1)
            return n;
        if(dp[n] != 0)
           return dp[n];
        dp[n] = fibTopDown(n-1, dp) + fibTopDown(n-2, dp);
        return dp[n];
    }

    public static long fibBottomUp(int n)
    {
        // This is the iterative approach with memorization  --- TC : O(n)  ,  SC : O(n)
        if(n==0 || n==1)
            return n;
        long dp[] = new long[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static long fib(int n)
    {
        // This is the iterative approach that is space optimized  --> TC : O(n)  ,  SC : O(1)
        if(n<=1)
           return n;
        long a = 0;
        long b = 1;
        long c = 0;
        for(int i=2; i<=n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nth term:");
        int n = sc.nextInt();
        long dp[] = new long[n+1];
        System.out.println("Fibonacci term through top-down approach      :" + fibTopDown(n, dp));
        System.out.println("Fibonacci term through bottom-up approach     :" + fibBottomUp(n));
        System.out.println("Fibonacci term through most-efficient approach:" + fib(n));
    }
}