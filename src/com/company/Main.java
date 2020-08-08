package com.company;

import java.util.Random;
import java.util.Scanner;

import static com.company.SortsAndSearches.*;

/**
 * Main Execution Class of the Sorting Program
 * @author Brian Chalfant 2020
 * CSCI2913
 * Exercise 6b
 */
public class Main {
    final private static Scanner scanner = new Scanner(System.in);
    final private static int MAXSIZE = 1000;
    private static int[] dataset = new int[0];

    /**
     * Main Execution Method, Runs the interface of the program
     * @param args not used
     */
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

    /**
     * Interface control to select Search or Sort Methods
     * @param data int array to be sorted
     * @param ascending boolean whether user wants data sorted ascending(true) or descending(false)
     */
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

    /**
     * Interface for Search methods, data will automatically be sorted using quicksort algorithm before Binary Search
     * to avoid errors.
     * @param data int array dataset to be searched
     */
    private static void searchArraySelection(int[] data) {
        int selection;
        searchArraySelectionMenu();
        selection = promptUser("Which Search Method would you like to use?: ");
        switch (selection) {
            case (1):
                searchArray(1, data);
            case (2):
                System.out.println("Sorting Data....");
                quickSort(data);
                searchArray(2, data)
                ; break;
        }
    }

    /**
     * searches the array using either method 1 or method 2 for user-defined search parameter,
     * displays index if found, otherwise displays Index not found
     * @param searchMethod int 1 = LinearSearch, 2= Binary Search
     * @param data int array dataset to search
     */
    private static void searchArray(int searchMethod, int[] data){
        int result = -1;
        if(searchMethod == 1){
            result = linearSearch(promptUser("What Number would you like to search for?: "), data);
        } else if(searchMethod == 2){
            result = binarySearch(promptUser("What Number would you like to search for?: "), data);
        }
        if(result == -1){
            System.out.println("Index not found");
        } else{
            System.out.println("Found at Index: " + result);
        }
    }

    /**
     * interface for Sorting Methods data is sorted and then reversed if the user desires descending order
     * @param data int array dataset to be sorted
     * @param ascending boolean does the user want data in ascending(true) or descending(false) order
     */
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

    /**
     * prints the array horizontally with line break every 20 numbers
     * automatically prints the menu after executing for better user experience
     * @param data int array dataset to be printed
     */
    private static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            if (i % 20 == 0 && i > 0) {
                System.out.println();
            }
        }
        System.out.println();
        printMenu();

    }

    /**
     * shuffles the dataset so that each element in the array is swapped with a another
     * random element in the array
     * @param data int array dataset to be shuffled
     */
    private static void shuffleArray(int[] data) {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            int randIndex = rand.nextInt(data.length - 1);
            int temp = data[randIndex];
            data[randIndex] = data[i];
            data[i] = temp;
        }

    }

    /**
     * fills active portion of the array with random integers whose values
     * range from 0 to length of active portion -1
     * @param data int array dataset with an active portion
     */
    private static void fillRandomly(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = ((int) (Math.random() * (data.length - 1)));
        }

    }

    /**
     * fills active portion of the array with sequential integers starting with 0
     * @param data int array dataset with an active portion
     */
    private static void fillSequentially(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

    }

    /**
     * creates a new array and sets the active portion to a user-defined size
     * @return int array new dataset
     */
    private static int[] setArraySize() {
        int size = promptUser("How Big Should the Array Be?: ");
        if (size < MAXSIZE) {
            return new int[size];
        } else {
            System.out.println("Input Above Max size of " + MAXSIZE);
            return new int[0];
        }
    }

    /**
     * prompts the user for an integer value
     * @param message String message to the user
     * @return int user input
     */
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

    /**
     * prints the user interface menu
     */
    public static void printMenu() {
        System.out.println("Sorting and Searching Demo");
        System.out.println("==========================");
        System.out.println("1) Select Array Size");
        System.out.println("2) Fill Array Sequentially");
        System.out.println("3) Fill Array Randomly");
        System.out.println("4) Shuffle Existing Array");
        System.out.println("5) Print Array Contents");
        System.out.println("6) Sorting Selection Menu");
        System.out.println("7) Toggle Ascending/Descending Sorting Order");
        System.out.println("--------------------------");
    }

    /**
     * prints the menu allowing for the user to pick searching or sorting
     */
    public static void ssArraySelectionMenu() {
        System.out.println("Sort/Search Selection Menu");
        System.out.println("==========================");
        System.out.println("1) Sorting");
        System.out.println("2) Searching");
    }

    /**
     * prints the sorting selection menu
     */
    public static void sortArraySelectionMenu() {
        System.out.println("Sorting Selection");
        System.out.println("=================");
        System.out.println("1) Bubble Sort");
        System.out.println("2) Selection Sort");
        System.out.println("3) Insertion Sort");
        System.out.println("4) QuickSort");
        System.out.println("-----------------");
    }

    /**
     * prints the searching selection menu
     */
    public static void searchArraySelectionMenu() {
        System.out.println("Search Selection");
        System.out.println("================");
        System.out.println("1) Linear Search");
        System.out.println("2) Binary Search");
        System.out.println("----------------");
    }

    /**
     * reverses the order of the array
     * @param data int array dataset to be reversed
     * @return int array reversed dataset
     */
    public static int[] reverseArray(int[] data) {
        int l = data.length;
        int[] reversedArray = new int[l];
        int j = l;
        for (int datum : data) {
            reversedArray[j - 1] = datum;
            j--;
        }
        return reversedArray;
    }

}

