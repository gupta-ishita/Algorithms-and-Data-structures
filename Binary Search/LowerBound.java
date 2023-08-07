/*
 * Find the lower bound in a sorted array arr for the given number n.
 * Lower Bound : Smallest index such that arr[index] >= n
 * 
 * Input : arr = [3, 5, 8, 15, 19] , n = 9
 * Output : 3
 */

public class LowerBound {
    private int ans;
    private int binarySearch_Interative (int A[], int n){
        int low = 0;
        int high = A.length - 1;
        int ans = A.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= n)
            {
                // This maybe our answer thus store it
                ans = mid;
                high = mid - 1; //since we need to find the smallest index, we iterate left
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private void binarySearch_Recursive(int A[], int target, int low, int high){
        if (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] >= target) {
                ans = mid;
                binarySearch_Recursive(A, target, low, mid - 1);
            }
            else
                binarySearch_Recursive(A, target, mid + 1, high);
        }
    }

    public static void main(String X[]){
        LowerBound obj = new LowerBound();
        int[] input = new int[]{3, 5, 8, 15, 19};
        System.out.println(obj.binarySearch_Interative(input, 9));
        obj.binarySearch_Recursive(input, 9, 0, 5);
        System.out.println(obj.ans);
    }
}

/*
 * Similar Questions :
 * 
 * 1) Find Upper Bound (Smallest index st arr[index] > n)
 * 2) Search insert position/index for a given number in a sorted array
 *    Input : arr = [1, 2, 4, 7], target = 6
 *    Output: 3
 */
