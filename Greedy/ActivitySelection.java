/*
Problem Statement : Given the start and end time of N jobs, find the maximum number of
                    non-overlapping jobs that can be performed. 

Input : n = 4 , list = [{2,3}, {1,4}, {5,8}, {6,10}]
Output : 2

Input : n = 4 , list = [{1,3}, {2,4}, {3,8}, {10,11}]
Output : 3
*/

/*
Solution : Take the greedy approach. Sort the jobs in increasing order of end time.
           Select the first job. Now, iterate through the sorted jobs and at each iteration, 
           select the next job if its start time is greater than the end time of 
           previously selected job and increment the counter by 1.
*/


import java.util.*;
class Activity
{
    int start;
    int end;
    Activity(int a, int b)
    {
        start = a;
        end = b;
    }
}

class ActivitySort implements Comparator<Activity>  
{
    // user-defined Comparator class to sort the array of Activities accrding to end time
    public int compare(Activity a, Activity b)
    {
        return a.end - b.end;
    }
}

class ActivitySelection 
{    
    public static int maximumActivity(Activity list[])
    {
        Arrays.sort(list, new ActivitySort()); // Sorts the array of activities  ---> TC : O(nlog n)
        int count = 1;
        int end = list[0].end;
        for(int i=1; i<list.length; i++)   // Iterate through array of activities ---> TC :O(n)
        {
            if(list[i].start >= end)
               {
                   count++;
                   end = list[i].end;
               }
        }
        // Overall TC : O(nlogn) + O(n) = O(nlogn)
        return count;
    }
  
    public static void main(String[] X)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of activities:");
        int n = sc.nextInt();
        Activity input[] = new Activity[n];
        
        System.out.println("Enter start and end of each activity:");
        for(int i=0; i<n; i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            Activity a = new Activity(s, e);
            input[i] = a;
        }

        System.out.println("Maximum no. of non-overlapping activities = " + maximumActivity(input));
    }
}
