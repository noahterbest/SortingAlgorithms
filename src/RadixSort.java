import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        // The exact array from assignment
        Integer[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the radix sort
        radixSort(arr);

        System.out.println("Final sorted array: " + Arrays.toString(arr));
    }

    // Radix Sort - sorts from least significant digit (rightmost) to most
    public static void radixSort(Integer[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        //Find the largest number so we know how many digits to process
        int max = getMax(arr);

        // Sort by each digit positi0n
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);

            // Print after each pass so you can see exactly what happens
            System.out.println("After sorting by " + exp + "s place: " + Arrays.toString(arr));
        }
    }

    //Find the maximum value in the array
    private static int getMax(Integer[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //Counting sort for ONE specific digit position (using exp)
    private static void countSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n];  // temporary space for the sorted version
        int[] count = new int[10];          // only 10 possible digits (0-9)

        //Count how many times each digit appears in this position
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        //Turn the count array into positions (cumulative sum)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //Build the output array (going backwards keeps it stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        //Copy everything back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}