/*
Problem Statement : For the given input array and an element K, Find the K largest  
                    elements from this array


Solution : Insert the elements into the min heap iteratively and extract minimum whenever the size 
           of heap exceeds K. This way only K largest elements remain in the heap.
*/


import java.util.*;
class KLargest
{
    public static List<Integer> findKLargest(List<Integer> numbers, int k)
    {
        if(k == numbers.size())
           return numbers;

        Queue<Integer> queue = new PriorityQueue<Integer>();
        // This loop ensures that there remain only K elements in the heap atmost
        for(int i=0; i<numbers.size(); i++)
        {
            int val = numbers.get(i);
            queue.add(val);      // Implements insert into the heap ---> TC : O(log k)
            if(queue.size() > k)
            {
                queue.poll();   // Extracts the minimum from the heap --> TC : O(log k)
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while(k > 0)   // Extracts minimum K times --> TC : k * O(log k)
        {
            int val = queue.poll(); 
            res.add(val);
            k--;
        }
        
        // Overall TC : n * O(log k) + (n-k) * O(log k) + k * O(log k)
        //            : O(nlogk)
        return res;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int size = sc.nextInt();
        List<Integer> input = new ArrayList<Integer>(size);
         
        System.out.println("Enter the numbers: ");
        for(int i=0; i<size; i++)
        {
            input.add(sc.nextInt());
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt();

        List<Integer> output = findKLargest(input, k);
        System.out.println("K-largest elements are:");
        for(int x: output)
        {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}