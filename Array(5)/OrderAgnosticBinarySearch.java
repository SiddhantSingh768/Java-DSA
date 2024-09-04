public class OrderAgnosticBinarySearch {

    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Check the order of the array
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // If the target is not found
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] ascendingArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] descendingArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        int target = 5;

        int resultAscending = search(ascendingArray, target);
        int resultDescending = search(descendingArray, target);

        System.out.println("Index of " + target + " in ascending order array: " + resultAscending);
        System.out.println("Index of " + target + " in descending order array: " + resultDescending);
    }
}
