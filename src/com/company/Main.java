package com.company;

import ibcsutils.ReadViaURL;

import static ibio.Helpers.input;

public class Main {

    public static void main(String[] args) {
        homework_1();
        homework_2();
        homework_4();

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

    static void homework_4() {
        String address = "http://www-personal.umich.edu/~jlawler/wordlist";
        String[] words = ReadViaURL.readWords(address, true, true, true);
        System.out.println(words[99]);

        String key = input("Enter a key: ");

        for (int index = 0; index < words.length; index++) {
            if (words[index].equals(key)) {
                System.out.println("Found key: " + key);
                break;
            }
        }

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
}