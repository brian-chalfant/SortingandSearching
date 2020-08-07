package com.company;

public class SelectionSort {

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
}
