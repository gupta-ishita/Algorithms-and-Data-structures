/*
Problem Statement : Merge k sorted lists and return it as one sorted list.

Input : [[1,4,5],[1,3,4],[2,6]]
Output : [1, 1, 2, 3, 4, 4, 5, 6]
*/

/*
Solution : Represent each element in of the list as an object containing 
           the triplet -(value, row in which element is present, position of element in that row).
           Insert the triplet object corresponding to the first element of each list into the min-heap.
           Iteratively, remove the object with least `value` and insert the next element of 
           same row. 
*/

import java.util.*;
class Triplet
{
    int value;
    int row;
    int col;
    Triplet(int a, int b, int c)
    {
        value = a;
        row = b;
        col = c;
    }
}

class MergeKSorted
{
    public static List<Integer> mergeArrays(List<List<Integer>> list)
    {
        // Let, K : No. of lists 
        //      N : No. of total elements
        Queue<Triplet> heap = new PriorityQueue<Triplet>((a, b) -> a.value - b.value);
        for(int i=0; i<list.size(); i++)
        {
            Triplet element = new Triplet(list.get(i).get(0), i, 0);
            heap.add(element);  // Adds first element of each list to the heap  --> TC : O(log K) 
        }

        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while(!heap.isEmpty())
        {
            Triplet temp = heap.poll(); // Removes the object with least 'value'  --> TC : O(log K)
            int r = temp.row;
            int c = temp.col;
            res.add(temp.value);
            if(c + 1 < list.get(r).size())
               heap.add(new Triplet(list.get(r).get(c+1), r, c+1));  // Adds the next object from the same row --> TC : O(log K)
            i = i + 1;
        }

        // Overall TC : K * O(log K) + (N) * O(log K) + (N-K) * O(log K)
        //            : O(N log K)
        return res;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> input = new ArrayList();
        System.out.println("Enter the number of rows");
        int m = sc.nextInt();        
        for(int i=0; i<m; i++)
        {
            List<Integer> list = new ArrayList<Integer>();
            System.out.println("Enter the number of elements in this row");
            int n = sc.nextInt();
            System.out.println("Enter the numbers");
            for(int j=0; j<n; j++)
            {                
                list.add(sc.nextInt());
            }
            input.add(list);
        }
        
        List<Integer> output = mergeArrays(input);
        System.out.println("Sorted list");
        for(int x: output)
        {
            System.out.print(x +" ");
        }
        System.out.println();
    }
}
