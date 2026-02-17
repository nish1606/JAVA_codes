public class InfiniteArray {

    public static void main(String[] args) {
        // Sorted array (acting like an infinite sorted array conceptually)
        int[] arr = {2, 3, 4, 5, 12, 13, 14, 24, 26, 35, 45, 67, 78, 89, 90, 100};

        int target = 35;

        // Call function to find index of target
        int res = ans(arr, target);

        System.out.println(res);
    }

    static int ans(int[] arr, int target){

        // Start with a small window of size 2
        int start = 0;
        int end = 1;

        // Expand the window until target <= arr[end]
        // Also make sure end does not go outside array length
        while (end < arr.length && target > arr[end]) {

            // New start will be just after current end
            int newStart = end + 1;

            // Increase window size exponentially
            // (current window size = end - start + 1)
            end = end + (end - start + 1) * 2;

            // If end crosses array size, set it to last index
            if (end >= arr.length) {
                end = arr.length - 1;
            }

            start = newStart;
        }

        // Once correct range is found, apply binary search
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while (start <= end) {

            // Prevents integer overflow
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;   // Search right half
            }
            else if (target < arr[mid]) {
                end = mid - 1;     // Search left half
            }
            else {
                return mid;        // Target found
            }
        }

        return -1;  // Target not found
    }
}
