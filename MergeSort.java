package com.company;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {20,35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
//    {20,35, -15, 7, 55, 1, -22}
    public static void mergeSort(int [] input, int start, int end) {

        if(end - start < 2) { // if we have one element array
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid); //left array
        mergeSort(input, mid, end); // right array
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start; // this variable represent left array
        int j = mid; // this variable represent right array
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
//        mid - 1 -- length of element that haven't been handle
        System.arraycopy(input, i, input, start + tempIndex, mid - i); // array that haven't been handle
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


}
