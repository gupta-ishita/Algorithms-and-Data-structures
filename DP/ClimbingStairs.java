/*
Problem : Given the number of steps n, find the number of distinct ways 
          to climb n the top if each time you can either climb 1 or 2 steps.

Input: 2
Output: 2

Input: 3
Output: 3
*/
import java.util.*;
class ClimbingStairs
{
    public static int countWays_TD(int stairs, int dp[])
    {
        // Recursive top-down approach ---> TC : O(n) , SC : O(n)
        if(stairs <= 1)
            return 1;
        if(dp[stairs] != 0)
            return dp[stairs];
        dp[stairs] = countWays_TD(stairs-1, dp) + countWays_TD(stairs-2, dp);
        return dp[stairs];
    }

    public static int countWays_BU(int stairs)
    {
        // Iterative bottom-up approach ---> TC : O(n) , SC : O(n)
        if(stairs <= 1)
            return 1;
        int dp[] = new int[stairs+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=stairs; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[stairs];
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of steps");
        int input = sc.nextInt();
        int dp[] = new int[input+1];
              
        System.out.println("No. of ways : " + countWays_TD(input, dp));
              
        System.out.println("No. of ways : " + countWays_BU(input));
    }
}
