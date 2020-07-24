/*
Problem Statement : Given an array A of integers, we must modify the array 
                    in the following way: we choose an i and replace A[i] 
                    with -A[i], and we repeat this process K times in total.  
                    (We may choose the same index i multiple times.)
    Return the largest possible sum of the array after modifying it in this way.
*/

/*
Solution : Maintain a min-heap of the elements. In each of the K-iterations, extract the 
           minimum most element, negative it  and insert it again. Now calculate the sum.
*/
import java.util.*;
class KNegations
{
    public static int negateK(List<Integer> list, int k)
    {
        Queue<Integer> heap = new PriorityQueue<Integer>(list); // Creates heap of size N --> TC : O(N)
        while(k > 0 && heap.peek()!=0)
        {
            int val = heap.poll();  // Extracts minimum element --> TC : O(log N)
            heap.add(-val);   // Inserts the modified element --> TC : O(log N)
            k--;
        }
        int sum = 0;
        Iterator<Integer> iter = heap.iterator();
        while(iter.hasNext())  // Iterates through the heap --> TC : O(N)
        {
            sum = sum + iter.next();
        }

        // Overall TC : O(N) + k * O(log N) + O(N)
        //            : O(klogN)
        return sum;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> input = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
        {
            input.add(sc.nextInt());
        }
        int K = sc.nextInt();
        System.out.println("Maximum sum after negations = " + negateK(input, K));
    }
}