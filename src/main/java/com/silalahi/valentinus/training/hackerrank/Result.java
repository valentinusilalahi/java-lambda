package com.silalahi.valentinus.training.hackerrank;


import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        // Sort the array in ascending order
        Collections.sort(arr);

        // Find the middle index
        int midIndex = arr.size() / 2;

        // If the array has an odd length, return the middle element
        if (arr.size() % 2 == 1) {
            return arr.get(midIndex);
        }

        // If the array has an even length, return the average of the middle two elements
        int midElement1 = arr.get(midIndex - 1);
        int midElement2 = arr.get(midIndex);
        return (midElement1 + midElement2) / 2;
    }

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(n - 1 - j);
                int bottomLeft = matrix.get(n - 1 - i).get(j);
                int bottomRight = matrix.get(n - 1 - i).get(n - 1 - j);
                sum += Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
            }
        }
        return sum;

    }

}
