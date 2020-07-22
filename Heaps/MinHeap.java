import java.util.*;
// Heap class ---> defines operations that can be performed on a min heap

class MinHeap
{
    static Scanner sc = new Scanner(System.in);
    int heap[];    // Implemented using an Array data structure
    int heapsize;
    
    MinHeap(int size)  
    {
        heapsize = size;
        heap = new int[2*heapsize];
    }
    
    void insert()
    {
        // Takes input into the array and then builds min-heap
        
        System.out.println("Enter the elements in the array");
        for(int i=0; i<heapsize; i++)
        {
            heap[i] = sc.nextInt();
        }
        BuildMinHeap();
    }
    
    void insert(int val)
    {
        //Inserts new element into the min-heap
        
        heapsize = heapsize + 1;
        int child = heapsize - 1;
        int parent = (child - 1)/2;
        heap[child] = val;
        while(parent>=0 && heap[parent]>heap[child])
        {
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;
            child = parent;
            parent = (parent - 1)/2;
        }
    }
    
    void MinHeapify(int i)
    {
        //Recursively heapify along the height of the tree for a given index
        
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < heapsize && heap[left] < heap[smallest])
        {
            smallest = left;
        }
        if(right < heapsize && heap[right] < heap[smallest])
        {
            smallest = right;
        }
        if(smallest != i)
        {
            int temp = heap[smallest];
            heap[smallest] = heap[i];
            heap[i] = temp;
            MinHeapify(smallest);
        }
    }
    
    void BuildMinHeap()
    {
        // Calls the MinHeapify function for all the non-leaf nodes of the tree
        
        for(int i=heapsize/2 - 1; i>=0; i--)
        {
            MinHeapify(i);
        }
    }
    
    int GetMin()
    {
        // Returns the minimum element of the heap
        
        if(heapsize == 0)
           {
               System.out.println("Underflow");
               return -99999;
           }
        return heap[0];
    }
    
    int ExtractMin()
    {
        // Returns the minimum and removes it from the heap
        
        if(heapsize == 0)
           {
               System.out.println("Underflow");
               return -99999;
           }
        int min = GetMin();
        heap[0] = heap[heapsize-1];
        heapsize = heapsize - 1;
        MinHeapify(0);
        return min;
    }
    
    void display()
    {
        //Print all the heap elements
        
        for(int i=0; i<heapsize; i++)
        {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] X)
    {
        System.out.println("Enter the size of heap");
        int size = sc.nextInt();
        
        MinHeap h = new MinHeap(size);
        
        System.out.println("Choose :");
        System.out.println("1: to create min heap");
        System.out.println("2: to insert new element in the existing heap");
        System.out.println("3: to get minimum element");
        System.out.println("4: to extract minimum from the heap");
        System.out.println(" Press any other key to exit");
        System.out.println("----------------------------------------------");
        
        // Menu driven loop to perform operations on Min Heap
        
        while(true)
        {
            int choice = sc.nextInt();
            switch(choice)
            {
            case 1:
                h.insert();
                System.out.println("List of elements : ");
                h.display();
                System.out.println("----------------------------------------------");
                break;
            case 2:
                System.out.println("Enter element to be inserted: ");
                int val = sc.nextInt();
                h.insert(val);
                System.out.println("New list of elements : ");
                h.display();
                System.out.println("----------------------------------------------");
                break;
            case 3:
                System.out.println(h.GetMin());
                System.out.println("----------------------------------------------");
                break;
            case 4:
                System.out.println("Removed Element : " + h.ExtractMin());
                System.out.println("List of remaining elements : ");
                h.display();
                System.out.println("----------------------------------------------");
                break;
            default:
                System.exit(0);   
            }
        }
        
        
        
    }
}
