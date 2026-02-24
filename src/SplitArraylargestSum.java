public class SplitArraylargestSum {
    public static void main(String[] args){
        int[] arr = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(arr, k));
    }
    static int splitArray(int[] nums, int k) {

            // Step 1: Initialize the search range
            // start = largest single element (minimum possible largest sum)
            // end = sum of all elements (maximum possible largest sum)
            int start = 0;
            int end = 0;
            for (int num : nums) {
                start = Math.max(start, num); // The largest single element
                end += num;                   // Sum of entire array
            }

            // Step 2: Binary search to find the minimum largest subarray sum
            while (start < end) {
                int mid = start + (end - start) / 2; // Candidate largest sum
                int sum = 0;                         // Current subarray sum
                int pieces = 1;                       // Number of subarrays needed

                // Step 2a: Greedily split array
                for (int num : nums) {
                    if (sum + num > mid) {
                        // Current subarray exceeds mid → start a new subarray
                        sum = num;
                        pieces++; // Increment number of subarrays
                    } else {
                        // Add to current subarray sum
                        sum += num;
                    }
                }

                // Step 2b: Adjust binary search range
                if (pieces <= k) {
                    // We can split into <= k subarrays → try smaller max sum
                    end = mid;
                } else {
                    // Too many subarrays → need larger max sum
                    start = mid + 1;
                }
            }

            // Step 3: start == end → minimum largest sum achievable
            return start;
        }
    }
