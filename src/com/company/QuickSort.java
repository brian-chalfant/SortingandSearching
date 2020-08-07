package com.company;

public class QuickSort {
    public static void main(String[] args) {
        int[] dataset = new int[] {5,6,4,7,3,2,8,9,0,1};
        quickSort(dataset);
        for(int i: dataset){
            System.out.print(i + " ");
        }
        System.out.println();

    }
    public static void quickSort(int[] data){
        quickSort(data, 0, data.length-1);
    }
    public static void quickSort(int[] data, int low, int high) {
        int pi;
        if(low<high){
            pi = partition(data, low, high);
            quickSort(data, low, pi-1);
            quickSort(data, pi+1, high);
        }


    }

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

}
