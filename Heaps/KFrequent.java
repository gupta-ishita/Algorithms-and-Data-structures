/*
Problem Statement : Given a non-empty array of integers, return the k most frequent elements.

Input: input = [1,1,1,2,2,3], K = 2
Output: [1,2]

Constraints:   k<=n
*/

/*
Solution : Count the frequency of each element and maintain it in a hash table.
           Create a heap of size K. Use comparator function to keep the least 
           freq element at the root. After iterating through all the elements, 
           the heap will contain K-most frequent elements.
*/

import java.util.*;
class KFrequent
{
    public static int[] topKFreq(int numbers[], int K)
    {
        if(K == numbers.length) //This handles the situation of K == N
           return numbers;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int x: numbers)
        {
            count.put(x, count.getOrDefault(x, 0) + 1);   // Counts frequency of each element -->O(1)
        } 

        Queue<Integer> heap = new PriorityQueue<Integer>( 
        (a, b) -> count.get(a) - count.get(b));

        for(int key: count.keySet())
        {
            heap.add(key);      // Inserts element into the heap --->  TC : O(log k)
            if(heap.size() > K)
            {
                heap.poll();   // Extracts least frequent element ---> TC : O(log k)
            }
        }
         
        int res[] = new int[K];
        for(int i=0; i<K; i++)
        {
            res[i] = heap.poll(); //Extracts K most frequent elements ---> TC : O(log k)
        }

        // Overall TC : n * O(1) + n * O(log k) + n * O(lok k) + k * O(log k)
        //            : O(nlogk)

        return res;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size:");
        int size = sc.nextInt();
        int input[] = new int[size];
        System.out.println("Enter the numbers:");
        for(int i=0; i<size; i++)
        {
            input[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K:");
        int K = sc.nextInt();
        int[] output = topKFreq(input, K);

        System.out.println("K most frequent elements:");
        for(int x: output)
        {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}