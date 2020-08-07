package com.company;

public class LinearSearch {
    public static int linearSearch(int searchParameter, int[] data) {
        int i;
        for (i = 0; i < data.length; i++) {
            if (data[i] == searchParameter) {

                return i;
            }
        }
        return -1;
    }
}
