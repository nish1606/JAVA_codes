public class RotatedBinarySearchwithDuplicates {
    public static void main(String[] args){
        int[] nums = {2,5,6,0,0,1,2};
        // Searching for element 5
        System.out.println(search(nums, 0));
    }
    static int search(int[] nums, int target){
        // Step 1: Find the pivot (largest element index)
        int pivot = FindPivotwithDuplicates(nums);

        // Case 1: If pivot not found → array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Case 2: If target is the pivot element
        else if (target == nums[pivot]) {
            return pivot;
        }

        // Case 3: Target lies in left sorted part
        else if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Case 4: Target lies in right sorted part
        else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    // Standard Binary Search
    static int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {

            // Prevent overflow
            int mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid + 1;
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            else {
                return mid; // Target found
            }
        }
        return -1; // Target not found
    }

    // Function to find pivot (largest element index)
    static int FindPivotwithDuplicates(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1: Mid is pivot (greater than next element)
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Case 2: Element before mid is pivot
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            else if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                if(nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                if(nums[end-1] > nums[end]){
                    return end-1;
                }
                end--;
            }
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1; // No pivot → array not rotated
    }
}
