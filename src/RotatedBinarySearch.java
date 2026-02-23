public class RotatedBinarySearch {

    public static void main(String[] args) {

        // Rotated sorted array
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10};

        // Searching for element 5
        System.out.println(search(arr, 5));
    }

    // Main search function
    static int search(int[] arr, int target) {

        // Step 1: Find the pivot (largest element index)
        int pivot = FindPivot(arr);

        // Case 1: If pivot not found → array is not rotated
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        // Case 2: If target is the pivot element
        else if (target == arr[pivot]) {
            return pivot;
        }

        // Case 3: Target lies in left sorted part
        else if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }

        // Case 4: Target lies in right sorted part
        else {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
    }

    // Standard Binary Search
    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            // Prevent overflow
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            else {
                return mid; // Target found
            }
        }

        return -1; // Target not found
    }

    // Function to find pivot (largest element index)
    static int FindPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1: Mid is pivot (greater than next element)
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: Element before mid is pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3: Left side is unsorted → pivot is in left
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            }

            // Case 4: Pivot is in right side
            else {
                start = mid + 1;
            }
        }

        return -1; // No pivot → array not rotated
    }
}