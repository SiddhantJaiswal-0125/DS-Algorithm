package Arrays;

import java.util.*;
class Soabclution {
    public static int minOperations(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int operations = 0;
        while (!isAllZero(arr)) {
            // Find leftmost non-zero element
            int firstNonZero = 0;
            while (firstNonZero < n && arr[firstNonZero] == 0) {
                firstNonZero++;
            }

            // If all elements are zero, break
            if (firstNonZero == n) break;

            // Find the maximum absolute value in current prefix
            int maxAbs = Math.abs(arr[firstNonZero]);
            int prefixEnd = firstNonZero;

            // Extend prefix to include all elements that can be handled together
            for (int i = firstNonZero + 1; i < n; i++) {
                if (arr[i] != 0) {
                    if ((arr[i] > 0 && arr[firstNonZero] > 0) ||
                            (arr[i] < 0 && arr[firstNonZero] < 0)
                    ) {
                        maxAbs = Math.max(maxAbs, Math.abs(arr[i]));
                        prefixEnd = i;
                    } else {
                        break;
                    }
                }
            }

            // Apply the operation
            int delta = arr[firstNonZero] > 0 ? -1 : 1;
            for (int i = 0; i <= prefixEnd; i++) {
                arr[i] += delta;
            }
            operations++;
        }

        return operations;
    }

    private static boolean isAllZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {3, 2, 0, 0, -1},  // Should output 5
        };

        for (int[] test : testCases) {
            int[] arrCopy = test.clone();
            System.out.print("Input: " + Arrays.toString(test));
            int result = minOperations(test);
            System.out.println(" -> Operations needed: " + result);
            System.out.println("Final array: " + Arrays.toString(test));
            System.out.println();
        }
    }
}

