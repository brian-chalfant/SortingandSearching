package com.company;

import java.util.Random;
import java.util.Scanner;

import static com.company.BubbleSort.bubbleSort;
import static com.company.InsertionSort.insertionSort;
import static com.company.LinearSearch.linearSearch;
import static com.company.BinarySearch.binarySearch;
import static com.company.QuickSort.quickSort;
import static com.company.SelectionSort.selectionSort;

public class Main {
    final private static Scanner scanner = new Scanner(System.in);
    final private static int MAXSIZE = 1000;
    private static int[] dataset = new int[0];
    public static void main(String[] args) {

        boolean quit = false;
        boolean ascending = true;
        printMenu();
        while (!quit) {
            System.out.println("8) Print The Menu Again");
            System.out.println("0) Quit");
            System.out.println();
            int selection = promptUser("Enter a Menu Option");
            switch (selection) {
                case (1):
                    dataset = setArraySize();
                    break;
                case (2):
                    fillSequentially(dataset);
                    break;
                case (3):
                    fillRandomly(dataset);
                    break;
                case (4):
                    shuffleArray(dataset);
                    break;
                case (5):
                    printArray(dataset);
                    break;
                case (6):
                    ssArraySelection(dataset, ascending);
                    break;
                case (7):
                    ascending = !ascending;
                    if (ascending) {
                        System.out.println("Sort Mode: Ascending");
                    } else {
                        System.out.println("Sort Mode: Descending");
                    }
                    break;
                case (8):
                    printMenu();
                    break;
                case (0):
                    quit = true;
                    break;
            }

        }
    }


    private static void ssArraySelection(int[] data, boolean ascending) {
        int selection;
        ssArraySelectionMenu();
        selection = promptUser("Would you like to Search or Sort?: ");
        switch (selection) {
            case (1):
                sortArraySelection(data, ascending);
                break;
            case (2):
                searchArraySelection(data);
                break;
        }

    }

    private static void searchArraySelection(int[] data) {
        int selection;
        searchArraySelectionMenu();
        selection = promptUser("Which Search Method would you like to use?: ");
        switch (selection) {
            case (1):
                System.out.println("Found at Index: " + linearSearch(promptUser("What Number would you like to search for?: "), data));
                break;
            case (2):
                System.out.println("Sorting Data....");
                quickSort(data);
                System.out.println("Found at Index: " + binarySearch(promptUser("What Number would you like to search for?: "), data));
                break;
        }
    }

    private static void sortArraySelection(int[] data, boolean ascending) {
        int selection;
        sortArraySelectionMenu();
        selection = promptUser("Which Sort Method would you like to use?: ");
            switch (selection) {
                case (1):
                    bubbleSort(data);
                    if(!ascending){
                        dataset = reverseArray(data);
                    }
                    break;
                case (2):
                    insertionSort(data);
                    if(!ascending){
                        dataset = reverseArray(data);
                    }
                    break;
                case (3):
                    selectionSort(data);
                    if(!ascending){
                        dataset = reverseArray(data);
                    }
                    break;
                case (4):
                    quickSort(data);
                    if(!ascending){
                        dataset = reverseArray(data);
                    }
                    break;
            }
        }


    private static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        printMenu();

    }

    private static void shuffleArray(int[] data) {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            int randIndex = rand.nextInt(data.length - 1);
            int temp = data[randIndex];
            data[randIndex] = data[i];
            data[i] = temp;
        }

    }

    private static void fillRandomly(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = ((int) (Math.random() * (data.length - 1)));
        }

    }

    private static void fillSequentially(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

    }

    private static int[] setArraySize() {
        int size = promptUser("How Big Should the Array Be?: ");
        if (size < MAXSIZE) {
            return new int[size];
        } else {
            System.out.println("Input Above Max size of " + MAXSIZE);
            return new int[0];
        }
    }

    public static int promptUser(String message) {

        int user_input1 = -1;
        System.out.print(message);
        try {
            user_input1 = scanner.nextInt();
            if (user_input1 < 0) {
                throw new IllegalArgumentException();
            }
            return user_input1;
        } catch (Exception e) {
            while (user_input1 < 0) {
                System.out.println("Invalid Entry, Please Enter a Positive Integer: ");
                scanner.nextLine();
                if (scanner.hasNextInt()) {
                    user_input1 = scanner.nextInt();
                }
            }
            return user_input1;
        }


    }

    public static void printMenu() {
        System.out.println("Sorting and Searching Demo");
        System.out.println("==========================");
        System.out.println("1) Select Array Size");
        System.out.println("2) Fill Array Sequentially");
        System.out.println("3) Fill Array Randomly");
        System.out.println("4) Shuffle Existing Array");
        System.out.println("5) Print Array Contents");
        System.out.println("6) Sorting Selection Menu");
        System.out.println("7) Toggle Ascending/Decending Sorting Order");
        System.out.println("--------------------------");
    }

    public static void ssArraySelectionMenu() {
        System.out.println("Sort/Search Selection Menu");
        System.out.println("==========================");
        System.out.println("1) Sorting");
        System.out.println("2) Searching");
    }

    public static void sortArraySelectionMenu() {
        System.out.println("Sorting Selection");
        System.out.println("=================");
        System.out.println("1) Bubble Sort");
        System.out.println("2) Selection Sort");
        System.out.println("3) Insertion Sort");
        System.out.println("4) QuickSort");
        System.out.println("-----------------");
    }

    public static void searchArraySelectionMenu() {
        System.out.println("Search Selection");
        System.out.println("================");
        System.out.println("1) Linear Search");
        System.out.println("2) Binary Search");
        System.out.println("----------------");
    }

    public static int[] reverseArray(int[] data) {
        int l = data.length;
        int[] reversedArray = new int[l];
        int j = l;
        for (int i = 0; i < l; i++) {
            reversedArray[j - 1] = data[i];
            j--;
        }
        return reversedArray;
    }

}

