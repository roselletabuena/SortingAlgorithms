package com.company;

public class QuickSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if(end - start < 2) { // check if we are dealing with one element.
            return;
        }

        int pivotIndex = partition(input, start, end); // where the pivot belong.
        quickSort(input, start, pivotIndex); //left subarray
        quickSort(input, pivotIndex + 1, end); // right subarray
    }

    public static int partition(int[] input, int start, int end) {
        // this is using the first element as the pivot
        int pivot = input[start];
        int i = start; // this index represent the left side of the array
        int j = end; // this index represent the right side of the array

        while (i < j) { // this condition check if the i and j cross each other.
            // NOTE: EMPTY LOOP
            // the loop below says that if the last element is greater than or equal the pivot then do nothing because its in the right place\
            // remember that we are comparing to right side here.
            while (i < j && input[--j] >= pivot); // this loop function to decrement j to find the pivot
            // if the while loop condition is false it means that the last element is less than the pivot then it need to swap position
            if(i < j) { // i < j is the condition to make sure the position doesn't cross to each other.
                input[i] = input[j];  // copy the last element to the position of pivot
            }

            // NOTE: empty loop body
            // ++i means we are moving to the next element and then we will compare it the our pivot
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
