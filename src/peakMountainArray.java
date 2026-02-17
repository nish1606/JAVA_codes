public class peakMountainArray {
    public static void main(String[] args) {

            // Example mountain array
            int[] arr = {0, 2, 5, 3, 1};

            int result = peakIndexInMountainArray(arr);

            System.out.println("Peak index is: " + result);
        }
        static int peakIndexInMountainArray(int[] arr) {

            int start = 0;
            int end = arr.length - 1;

            // We use start < end to prevent out of bounds
            // because we are checking arr[mid + 1]
            while (start < end) {

                // Calculate middle index
                int mid = start + (end - start) / 2;

                // If middle element is greater than next element,
                // we are in the descending part of mountain
                if (arr[mid] > arr[mid + 1]) {

                    // Peak could be at mid or left side
                    end = mid;

                } else {

                    // We are in ascending part
                    // So peak must be on right side
                    start = mid + 1;
                }
            }

            // When start == end, that index is the peak
            return start;
        }
}

