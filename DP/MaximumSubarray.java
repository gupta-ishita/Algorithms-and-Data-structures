/*
Problem : Given an array of numbers, find the maximum contiguous subarray sum possible.

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6

*/
import java.util.*;
class MaximumSubarray
{
    public static int maximumSum(int numbers[])
    {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i=0; i<numbers.length; i++)
        {
            curr_sum = curr_sum + numbers[i];
            if(curr_sum > max_sum)
               max_sum = curr_sum;
            if(curr_sum < 0)
               curr_sum = 0;
        }
        // TC : O(n) , SC : O(1)
        return max_sum;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        for(int i=0; i<n; i++)
        {
            input[i] = sc.nextInt();
        }
        System.out.println(maximumSum(input));
    }
}