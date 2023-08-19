/*
 * Find the floor and ceil of the given number in a sorted array.
 * Floor : Largest number <= n
 * Ceil : Smallest number >= n
 * 
 * Input : A = [1, 2, 4, 7] , n = 6
 * Output: 4 , 7
 */
public class FloorAndCeil {
    private int findFloor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int floor = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] <= target){
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    private int findCeil(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ceil = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] >= target)
            {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] X) {
        FloorAndCeil obj = new FloorAndCeil();
        int arr[] = new int[]{1, 2, 4, 7};
        System.out.println(obj.findFloor(arr, 6));
        System.out.println(obj.findCeil(arr, 6));
    }
}
