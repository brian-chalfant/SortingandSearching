package com.company;

public class BubbleSort {

    public static int[] bubbleSort(int[] workingCopy) {
        int size = workingCopy.length;
        for(int i = 0;i < size-1;i++){
            //outer loop
            for(int j = 0; j < size-i-1; j++){
                //inner loop
                //compare leftmost variable against its right neighbor
                if(workingCopy[j] > workingCopy[j+1]){
                    //left is smaller than right so swap them
                    int temp = workingCopy[j];
                    workingCopy[j] = workingCopy[j+1];
                    workingCopy[j+1] = temp;
                    //swapped
                }
                // left is bigger than right so do nothing
                //inner loop
            }
            //outer loop
        }
        return workingCopy;
    }
}
