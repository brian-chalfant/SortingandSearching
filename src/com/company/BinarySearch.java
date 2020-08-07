package com.company;

public class BinarySearch {
    public static int binarySearch(int searchParameter, int[] data) {
        int cursor = data.length / 2;
        int lBound = 0;
        int uBound = data.length;
        boolean found = false;
        while (!found) {
            if(uBound - lBound == 1){
                break;
            }
            if (data[cursor] == searchParameter) {
                found = true;
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
