public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10};
        System.out.println(counts(arr));
    }
    static int counts(int[] arr){
        int pivot = FindPivot(arr);
        return pivot+1;
    }
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
