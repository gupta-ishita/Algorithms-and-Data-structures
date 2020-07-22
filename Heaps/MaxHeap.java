import java.util.*;

class MaxHeap
{
    static Scanner sc = new Scanner(System.in);
    int heap[];
    int heapsize;
    
    MaxHeap(int cap)
    {
        heapsize = cap;
        heap = new int[2*heapsize];
    }
    
    void maxHeapify(int i)   // TC : O(log n)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < heapsize && heap[left] > heap[largest])
           largest = left;
        if(right < heapsize && heap[right] > heap[largest])
           largest = right;
        if(largest != i)
        {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }
    
    void insert()  // TC : O(n)
    {
        System.out.println("Enter elements to be inserted");
        for(int i=0; i<heapsize; i++)
        {
            heap[i] = sc.nextInt();
        }
        buildMaxHeap();
    }
    
    
    void insert(int val)  // TC : O(log n)
    {
        heapsize = heapsize + 1;
        int child = heapsize - 1;
        int parent = (child - 1)/2;
        heap[heapsize-1] = val;
        while(parent >= 0 && heap[parent] < heap[child])
        {
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;
            child = parent;
            parent = (parent - 1)/2;
        }
    }
    
    void buildMaxHeap()  //TC : O(n)
    {
        for(int i=heapsize/2-1; i>=0; i--)
        {
            maxHeapify(i);
        }
    }
    
    int getMax()  //TC : O(1)
    {
        if(heapsize == 0)
           return Integer.MAX_VALUE;
        return heap[0];
    }
    
    int extractMax()  // TC : O(log n)
    {
        if(heapsize == 0)
           {
               return Integer.MAX_VALUE;
           }
        int val = getMax();
        heap[0] = heapsize-1;
        heapsize--;
        if(heapsize!=0)
            maxHeapify(0);
        return val;
    }
    
    void display()  // TC : O(n)
    {
        for(int i=0; i<heapsize; i++)
        {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] X)
    {
       
    System.out.println("Enter size:");
    int size = sc.nextInt();
    
    MaxHeap h = new MaxHeap(size);
    
    System.out.println("Choose :");
    System.out.println("1: to create max heap");
    System.out.println("2: to insert new element in the existing heap");
    System.out.println("3: to get maximum element");
    System.out.println("4: to extract maximum from the heap");
    System.out.println("Press any other key to exit");
    System.out.println();
    System.out.println("----------------------------------------------");
    
    while(true)
        {
            int choice = sc.nextInt();
            switch(choice)
            {
            case 1:
                h.insert();
                System.out.println("Elements in the heap : ");
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
                System.out.println(h.getMax());
                System.out.println("----------------------------------------------");
                break;
            case 4:
                System.out.println("Removed Element : " + h.extractMax());
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
