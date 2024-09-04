// Peak Index in a Biotonic or mountain array 
//An array is said to be biotonic if it is first increasing and then decreasing or entirely increasing or decreasing
public class MountainArray {
    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Find the peak element
        int peak = findPeak(arr, start, end);

        // Check if the target is the peak element
        if (target == arr[peak]) {
            return peak;
        }

        // Search in the first half
        int firstTry = orderAgnosticBinarySearch(arr, target, start, peak - 1);

        // If element found in first half return
        if (firstTry != -1) {
            return firstTry;
        }

        // Search in the second half
        return orderAgnosticBinarySearch(arr, target, peak + 1, end);
    }
    public static int findPeak(int[] arr, int start, int end) {
        // Iterate until two elements are left
        while (start < end) {
            // Find the mid index
            int mid = start + (end - start) / 2;

            // Check if mid element is greater than mid + 1 element
            if (arr[mid] > arr[mid + 1]) {
                // If yes, then we are in the decreasing part of the array
                // This means that mid may be the peak element
                // We cannot discard mid, hence end != mid - 1
                end = mid;
            } else {
                // If no, then we are in the increasing part of the array
                // Mid + 1 element may be the peak element
                // Hence we can discard mid and mid + 1 both
                // Hence start = mid + 1
                start = mid + 1;
            }
        }

        // In the end, start == end and pointing to the peak element
        return start;
    }
    public static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        // Check if array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // Find the middle element
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        // If not found
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int target = 4;
        int result = search(arr, target);
        System.out.println(result);
    }
}
