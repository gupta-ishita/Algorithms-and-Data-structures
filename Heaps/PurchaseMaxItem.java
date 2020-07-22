/*
Problem Statement : For a given array of item costs and total available amount, find the maximum number of items
that can be purchased from the this amount

Input :  cost = [1, 12, 5, 111, 200] , sum = 10
Output : 2 

Input : cost = [20, 10, 5, 30, 100] , sum = 35
Output : 3  
*/

/*
Solution : Implement the greedy approach. Select the minimum cost item iteratively.
*/
import java.util.*;
class PurchaseMaxItem
{
    public static int countMaxItem(List<Integer> cost, int sum)
    {
        Queue<Integer> pq = new PriorityQueue<Integer>(cost);  
        /*   Internally priority queue is implemented as a min-heap in Java
             Builds heap from the given collection of costs -->  TC : O(n)  */
        
        int count = 0;
        while(sum > 0 && pq.peek() <= sum)  // peek() returns min element from the heap ---> TC : O(1)
        {
            count++;
            int val = pq.poll();   // poll() is extracts the minimum from the heap ---> TC : O(logn)
            sum = sum - val;
        }       
        /* Overall TC = O(n + count*logn)    
                      = O(n)                    , assuming count << n,  */
        return count;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> cost = new ArrayList<Integer>(n);        
        for(int i=0; i<n; i++)
        {
            cost.add(sc.nextInt());
        }
        int sum = sc.nextInt();

        System.out.println(countMaxItem(cost, sum));
    }
}