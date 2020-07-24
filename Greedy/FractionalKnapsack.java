/*
Problem Statement : Given the weight and value of N items and the maximum capacity of knapsack, 
                    find the maximum profit that can be obtained by selecting these items. 
*/

/*
Solution : Take the greedy approach. Sort the input in descending order of value/weight.  
           Start iterating from the starting position and select the whole item if the its 
           weight is less than the capacity else select only the fractional item. Update the 
           capacity and profit at each iteration. 
*/
import java.util.*;
class Item
{
    // Item class to represent each item in terms of (weight, value, and value per weight)
    int weight;
    int value;
    double cost;
    Item(int w, int v)
    {
        weight = w;
        value = v;
        cost = (double)value / (double)weight;
    }
}

class ItemComparator implements Comparator<Item>
{
    // Comparator class to implement user-defined comparison thats sorts the list 
    // according to value per weight
    public int compare(Item i1, Item i2)
    {
        String c1 = Double.toString(i1.cost);
        String c2 = Double.toString(i2.cost);
        return c2.compareTo(c1);  
    }
}
class FractionalKnapsack
{
    public static double maxProfit(Item list[], int capacity)
    {
        Arrays.sort(list, new ItemComparator());  // Sorts the list of Item objects --> TC : O(log n)
        double profit = 0;
        
        for(int i=0; i<list.length; i++)    
        {
            if(list[i].weight <= capacity)   //Picks up the whole item
            {
                profit = profit + list[i].value;
                capacity = capacity - list[i].weight;
            }
            else                            // Picks up the fractional weight of the item
            {
                profit = profit + list[i].cost * capacity;
                capacity = 0;
                break;
            }

            if(capacity == 0)
               break;
        }

        // Overall TC : O(nlogn) + O(n)
        return profit;
    }
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        Item list[] = new Item[n];
        System.out.println("Enter the weight and value of each item: ");
        for(int i=0; i<n; i++)
        {
            int w = sc.nextInt();
            int v = sc.nextInt();
            list[i] = new Item(w, v);
        }
        
        System.out.println("Enter the max capacity: ");
        int cap = sc.nextInt();
        System.out.println("Max profit = " + maxProfit(list, cap));
    }
}