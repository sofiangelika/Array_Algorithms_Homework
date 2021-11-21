package com.company;

import ibcsutils.ReadViaURL;

import java.util.Arrays;

import static ibio.Helpers.input;

public class Main {

    public static void main(String[] args) {
        homework_1();
        homework_2();
        homework_3();
        homework_4();
        homework_5();

    }

    static void homework_1() {
        int[] array = {-2, 9, 11, 12, 13, 14, 15, 22, 142};
        int n = array.length;
        int key = 15;

        int lo = 0;
        int hi = n - 1;
        boolean found = false;

        while (!found && lo <= hi) {
            int mid = (lo + hi) / 2;
            int v = array[mid];

            if (key == v)
                found = true;
            else if (key < v)
                hi = mid - 1;
            else
                lo = mid + 1;
            System.out.println(v);
        }
    }

    static void homework_2() {
        String[] students = {"Alissa", "Ben", "Charlie", "Dianna"};
        String[] grades = {"B", "D", "B", "A"};
        String key = "Charlie";

        for (int index = 0; index < students.length; index++) {
            if (students[index].equals(key))
                System.out.println(grades[index]);
        }
    }

    static void homework_3() {
        //selection sort
        int[] data = {-4, 11, 7, -12, 6, 1};
        for (int i = 0; i < data.length - 1; i++) {
            int ind_smallest = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[ind_smallest])
                    ind_smallest = j;
            }
            swap(data, i, ind_smallest);
            System.out.println(Arrays.toString(data));
        }

        //bubble sort
        final int n = data.length;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i <= n - 2; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                    changed = true;
                }
                System.out.println(Arrays.toString(data));
            }
        }
    }

    static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    static void homework_4() {
        String address = "http://www-personal.umich.edu/~jlawler/wordlist";
        String[] words = ReadViaURL.readWords(address, true, true, true);
        System.out.println(words[99]);

        String key = input("Enter a key: ");

        //sequential search
        for (int index = 0; index < words.length; index++) {
            if (words[index].equals(key)) {
                System.out.println("Found key: " + key);
                break;
            }
        }

        //binary search
        int lo = 0;
        int hi = words.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            String one_word = words[mid];
            if (one_word.equals(key)) {
                System.out.println("Found key: " + key);
                break;
            } else if (key.compareTo(one_word) < 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
    }

    static void homework_5() {
        int[] numbers = {9, -28, 4, 10, -2};
        for (int i = 1; i < numbers.length; i++) {
            int val = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > val) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = val;
        }
    }

}
