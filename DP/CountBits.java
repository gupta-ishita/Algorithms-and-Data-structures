/*
Problem : Given a non negative integer number, find the 
          number of 1's in their binary representation 
          and return them as an array, for every numbers i 
          in the range 0 ≤ i ≤ num.

Input: 2
Output: [0,1,1]

Input: 5
Output: [0,1,1,2,1,2]
*/

import java.util.*;

class CountBits
{
    public static int[] countOnes(int n)
    {
        int dp[] = new int[n+1];
        if(n >= 1)
            dp[1] = 1;
        int offset = 2;
        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i - offset] + 1;
            if(2*offset == i + 1)
               offset = i + 1;            
        }
        // TC : O(n) , SC : O(n)
        return dp;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        int[] output = countOnes(n);
        for(int x: output)
        {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}