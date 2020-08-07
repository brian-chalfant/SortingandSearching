package com.company;

public class InsertionSort {

    public static void main(String[] args) {

        int[] data = new int[] {9,5,7,6,8,4,3,7,1,0};

        insertionSort(data);
        for(int i: data){
            System.out.print(i);
        }
        System.out.println();
    }

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
    }
/**
 *  void sort(int arr[])
 *     {
 *         int n = arr.length;
 *         for (int i=1; i<n; ++i)
 *         {
 *             int key = arr[i];
 *             int j = i-1;
 *
 *             /* Move elements of arr[0..i-1], that are
 *             greater than key, to one position ahead
 *             of their current position
 *while(j>=0&&arr[j]>key)
         *{
         *arr[j+1]=arr[j];
         *j=j-1;
         *}
         *arr[j+1]=key;
         *}
         *}
 */
