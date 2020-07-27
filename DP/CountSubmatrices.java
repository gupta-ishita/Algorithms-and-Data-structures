/*
Problem : Given a n X m matrix of ones and zeros, return the 
          count of square submatrices having all ones.

Input: matrix =
[ [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]]
Output: 15

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
*/

import java.util.*;
class CountSubmatrices
{
    public static int count(int[][] matrix, int n, int m)
    {
        int count = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(i>0 && j>0)
                {
                    if(matrix[i][j] == 1)
                       matrix[i][j] = 1 + Math.min(matrix[i][j-1], Math.min(matrix[i-1][j], matrix[i-1][j-1]));
                }
                count = count + matrix[i][j];
            }
        }
        // TC : O(n*m)   ,  SC : O(n*m)
        return count;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int input[][] = new int[r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                input[i][j] = sc.nextInt();
            }
        }
        System.out.println(count(input, r, c));
    }
}