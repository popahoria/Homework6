package com.fasttrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Exercises {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        numbersSum(s); //1
        oddNumbers(s); //2
        isGreater(s);  //3
        fundRaising(s, false); //4
        fundRaising(s, true); //5
        individualSentences(s); //6
    }

    public static void numbersSum(Scanner s) {
        System.out.println("Enter the numbers of elements in array ");
        int number = s.nextInt();
        int[] elements = new int[number];
        int sum = 0;
        System.out.println("enter elements");
        for (int i = 0; i < number; i++) {
            elements[i] = s.nextInt();
        }
        for (int i = 0; i < elements.length; i++) {
            sum = sum + elements[i];
        }
        System.out.println("Sum of all numbers of the array = " + sum);
    }

    public static void oddNumbers(Scanner s) {
        System.out.println("Enter the numbers of elements in array ");
        int number = s.nextInt();
        int[] elements = new int[number];


        System.out.println("enter elements");
        for (int i = 0; i < number; i++) {
            elements[i] = s.nextInt();
        }
        System.out.println();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 != 0) {
                System.out.print(elements[i] + ", ");
            }
        }
        System.out.println(" are odd numbers");
    }

    public static void isGreater(Scanner s) {
        System.out.println("Enter the numbers of elements in array ");
        int number = s.nextInt();
        int[] elements = new int[number];
        System.out.println("enter elements");
        for (int i = 0; i < number; i++) {
            elements[i] = s.nextInt();
        }
        System.out.println("Enter a number to compare with each element of array");
        Scanner s2 = new Scanner(System.in);
        int compareNumber = s2.nextInt();
        List<Integer> greaterNumbers = new ArrayList<Integer>();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > compareNumber) {
                greaterNumbers.add(elements[i]);
            }
        }
        if (greaterNumbers.size() == 0) {
            System.out.println("no number greater then " + compareNumber);
        } else {
            System.out.println("greatest numbers are " + greaterNumbers.toString());
        }
    }

    public static void individualSentences(Scanner s) {
        System.out.println("Enter paragraph");
        String str = s.nextLine();
        do {
            System.out.println(str.substring(0, (str.indexOf(".") + 1)));
            str = str.substring((str.indexOf(".") + 1), str.length());
            str = str.trim();
        } while (str.indexOf(".") != -1);
    }

    public static void fundRaising(Scanner s, boolean useLimit) {
        System.out.println("Enter target");
        int target = s.nextInt();
        int totalDonations = 0;
        Random random = new Random();
        int donation = 0;

        int limit = 0;
        int donationsMade = 0;

        if (useLimit) {
            System.out.print("Enter donations limit: ");
            limit = s.nextInt();
        }

        do {
            donation = random.nextInt(1, target + 1);
            System.out.println("donation" + donation);
            totalDonations += donation;
            donationsMade++;
        } while ((!useLimit && totalDonations < target) || (useLimit && (totalDonations < target) && (limit > donationsMade)));

        if (useLimit && donationsMade >= limit) {
            System.out.println("Donations limit was reached");
        }

        System.out.println("Total donations: " + totalDonations);
    }
}

