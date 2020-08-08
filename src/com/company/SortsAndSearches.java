package com.company;

/**
 * Various Sorts and Searches with helper Methods
 * Bubble Sort
 * Insertion Sort
 * QuickSort
 *  - Partition
 * Selection Sort
 * Linear Search
 * Binary Search
 * @author Brian Chalfant 2020
 * CSCI2913
 * Exercise 6b
 *
 */
public class SortsAndSearches {


    /**
     * Bubble Sort: Sorting Algorithm Average Time Complexity O(n^2)
     * @param dataset int array dataset to be sorted
     */
    public static void bubbleSort(int[] dataset) {
        int size = dataset.length;
        for(int i = 0;i < size-1;i++){
            //outer loop
            for(int j = 0; j < size-i-1; j++){
                //inner loop
                //compare leftmost variable against its right neighbor
                if(dataset[j] > dataset[j+1]){
                    //left is smaller than right so swap them
                    int temp = dataset[j];
                    dataset[j] = dataset[j+1];
                    dataset[j+1] = temp;
                    //swapped
                }
                // left is bigger than right so do nothing
                //inner loop
            }
            //outer loop
        }
    }

    /**
     * Insertion Sort: Sorting Algorithm Average Time Complexity O(n^2)
     * @param dataset int array dataset to be sorted
     */
    public static void insertionSort(int[] dataset){
        int size = dataset.length;
        for(int i= 1; i < size; i++){
            int temp = dataset[i];
            int cursor = i - 1;
            while(cursor >=0 && temp < dataset[cursor]){
                dataset[cursor + 1] = dataset[cursor];
                cursor--;
            }
            dataset[cursor + 1] = temp;



            }

        }


    /**
     * QuickSort: Sorting Algorithm Average Time Complexity 0(n log(n))
     * @param data int array dataset to be sorted
     */
    public static void quickSort(int[] data){
        quickSort(data, 0, data.length-1);
    }

    /**
     * recursive method for Quicksort Algorithm
     * @param data int array dataset to be sorted
     * @param low lowest index of partition to be sorted
     * @param high highest index of partition to be sorted
     */
    public static void quickSort(int[] data, int low, int high) {
        int pi;
        if(low<high){
            pi = partition(data, low, high);
            quickSort(data, low, pi-1);
            quickSort(data, pi+1, high);
        }


    }

    /**
     * helper method for Quicksort, finds the partition
     * @param data int array dataset to be sorted
     * @param low lowest index of partition
     * @param high highest index of partition
     * @return the pivot for the next section
     */
    public static int partition(int[] data, int low, int high){
        int pivot = data[high];
        int i = low-1;
        for(int j = low; j<=high;j++){
            if (data[j] < pivot){
                int temp = data[j];
                i++;
                data[j] = data[i];
                data[i] = temp;

            }
        }
        int temp = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;
        return (i+1);
    }

    /**
     * Selection Sort: Sorting Algorithm AverageTime Complexity 0(n^2)
     * @param dataset int array dataset to be sorted
     */
    public static void selectionSort(int[] dataset) {
        int lowestNumber = Integer.MAX_VALUE;
        int lowestIndex = 0;
        int size = dataset.length;

        //find lowest number
        for(int i = 0; i< size-1;i++){
            //outer loop
            for(int j = i; j< size; j++){
                if (dataset[j] < lowestNumber){
                    lowestNumber = dataset[j];
                    lowestIndex = j;
                }
            }
            int temp = dataset[i];
            dataset[i] = lowestNumber;
            dataset[lowestIndex] = temp;
            lowestNumber = Integer.MAX_VALUE;
        }// return dataset;
    }

    /**
     * Linear Search: Linear Searching Algorithm Average Time Complexity 0(n)
     * @param searchParameter integer to search for
     * @param data int array dataset to search
     * @return index data was found
     */
    public static int linearSearch(int searchParameter, int[] data) {
        int i;
        for (i = 0; i < data.length; i++) {
            if (data[i] == searchParameter) {

                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search: Recursive Searching Algorithm Average Time Complexity O(log(n))
     * @param searchParameter integer to search for
     * @param data int array dataset to search
     * @return index data was found
     */
    public static int binarySearch(int searchParameter, int[] data) {
        int cursor = data.length / 2;
        int lBound = 0;
        int uBound = data.length;
        while (uBound - lBound != 1) {
            if (data[cursor] == searchParameter) {
                return cursor;
            } else if (data[cursor] < searchParameter) {
                lBound = cursor;
                cursor += ((uBound - lBound) / 2);
            } else {
                uBound = cursor;
                cursor = cursor / 2;
            }
        }
        return -1;
    }
}
