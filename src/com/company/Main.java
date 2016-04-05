package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Total Beers:");
        System.out.println(InterviewQuestions.totalBeers(10, 1, 5));

        System.out.println("Lift off:");
        InterviewQuestions.liftOff(5);
        System.out.println("Clock angle:");
        System.out.println(InterviewQuestions.clockAngle(3,30));
        System.out.println("Sum intersections:");
        System.out.println(InterviewQuestions.sum_intersection(1 ,6, 4, 5) == 9);
        System.out.println(InterviewQuestions.sum_intersection(1,4, 6,10) == 0);
        System.out.println(InterviewQuestions.sum_intersection(1,6,4,10) == 15);
        System.out.println(InterviewQuestions.sum_intersection(4,10,1,6) == 15);
        System.out.println("Sum intersections v2:");
        System.out.println(InterviewQuestions.sum_intersection_v2(1 ,6, 4, 5) == 9);
        System.out.println(InterviewQuestions.sum_intersection_v2(1,4, 6,10) == 0);
        System.out.println(InterviewQuestions.sum_intersection_v2(1,6,4,10) == 15);
        System.out.println(InterviewQuestions.sum_intersection_v2(4,10,1,6) == 15);
        System.out.println("sum of array:");
        int arr[][] = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] test = new int[][]{{1,2,3}, {4,5,6}};
        System.out.println(InterviewQuestions.multi_array_sum(arr) == 18);
        System.out.println("sudokuValidator: ");
        int sudokuTest[][] = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };
        int failSudokuTest[][] = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {1,1,5,2,8,6,1,7,9}
        };
        System.out.println(InterviewQuestions.sudokuValidator(sudokuTest));
        System.out.println(!InterviewQuestions.sudokuValidator(failSudokuTest));
        System.out.println("pair sum v1 :");
        System.out.println(InterviewQuestions.pair_sum(new int[]{1,2,3,4}, 5));
        System.out.println(!InterviewQuestions.pair_sum(new int[]{1,2,3,4}, 8));
        System.out.println(InterviewQuestions.pair_sum_v2(new int[]{1,2,3,4}, 5));
        System.out.println(!InterviewQuestions.pair_sum_v2(new int[]{1,2,3,4}, 8));
        System.out.println("Coin Change: ");
        System.out.println(InterviewQuestions.coinChange(new int[]{1,2,3}, 6)); // divide by zero call

        System.out.println("Tower of Hanoi:");
        InterviewQuestions.towerOfHanoi(3, "start", "finish");

        System.out.println("Is it unique?");
        System.out.println(InterviewQuestions.isUnique("abcd"));
        System.out.println(!InterviewQuestions.isUnique("abad"));
        System.out.println("Is it unique hash table version?");
        System.out.println(InterviewQuestions.isUnique_HashTable("abcd"));
        System.out.println(!InterviewQuestions.isUnique_HashTable("abad"));

        System.out.println("Is it a perm string?");
        System.out.println(InterviewQuestions.isPerm("dog", "god"));
        System.out.println(!InterviewQuestions.isPerm("dog", "dag"));
        System.out.println(InterviewQuestions.isPerm("a", "a"));
        System.out.println(!InterviewQuestions.isPerm("a", "d"));
        System.out.println(!InterviewQuestions.isPerm("a", "da"));

        System.out.println("Is it a perm string with a sort?");
        System.out.println(InterviewQuestions.isPerm_sort("dog", "god"));
        System.out.println(!InterviewQuestions.isPerm_sort("dog", "dag"));
        System.out.println(InterviewQuestions.isPerm_sort("a", "a"));
        System.out.println(!InterviewQuestions.isPerm_sort("a", "d"));
        System.out.println(!InterviewQuestions.isPerm_sort("a", "da"));

        System.out.println("Does urlify iteractive work?");
        System.out.println(InterviewQuestions.URLify_iterative("mr john smith    ".toCharArray(), 13)); //mr%20john%20smith
        // very flimsy, it only works if it is exact with a single space

        System.out.println("Does the palindrome perm work?");
        System.out.println(InterviewQuestions.PalindromePermutation("tact coa"));
        System.out.println(InterviewQuestions.PalindromePermutation("tacT coa"));
        System.out.println(InterviewQuestions.PalindromePermutation("tacT ca"));
        System.out.println(!InterviewQuestions.PalindromePermutation("balloon"));

        System.out.println("One Away");
        System.out.println(InterviewQuestions.oneAway("pale", "ple"));
        System.out.println(InterviewQuestions.oneAway("pales" , "pale"));
        System.out.println(InterviewQuestions.oneAway("pale", "bale"));
        System.out.println(!InterviewQuestions.oneAway("pale", "bake"));

        System.out.println("String Compression");
        System.out.println(InterviewQuestions.stringCompression("aabcccccaaa"));

        System.out.println("Matrix rotate");
        // considerations, what if it's 1
        int[][] goodTest = new int[][]{{1,2,3,4},{5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] oneTest = new int[][]{{1}};
        System.out.println(InterviewQuestions.rotateMatrix(goodTest));
        System.out.println(InterviewQuestions.rotateMatrix(oneTest));


        System.out.println("Matrix rotate");
        // considerations, what if it's 1
        int[][] zeroTest = new int[][]{{1,0,3,4},{5,6,7,8}, {9,10,11,12}, {13,14,0,16}};
        int[][] zeroOneTest = new int[][]{{0}};
        System.out.println(InterviewQuestions.zeroMatrix(zeroTest));
        System.out.println(InterviewQuestions.zeroMatrix(zeroOneTest));

        System.out.println("Check if substring of other");
        System.out.println(InterviewQuestions.isSubString("waterbottle", "erbottlewat"));
        System.out.println(!InterviewQuestions.isSubString("waterbottle", "erbottlewatA"));

        System.out.println("Max profit in a day");
        System.out.println(InterviewQuestions.maxProfitInADay(new int[]{10, 7, 5, 8, 11, 9}));

        // Issues with the main cases - need to check them out
        System.out.println("remove code to remove duplicates in teh linkedlist");
        System.out.println(InterviewQuestions.removeDuplicates(new LinkedList<Integer>(Arrays.asList(1,2,3,1,4))));
        // what's wrong with the below
        System.out.println(InterviewQuestions.removeDuplicates(new LinkedList<Integer>(Arrays.asList(6,6,1,2,3,1,4,2,3,4,6,6))));
        System.out.println(InterviewQuestions.removeDuplicatesWithNoDS(new LinkedList<Integer>(Arrays.asList(1,2,3,1,4))));
        System.out.println(InterviewQuestions.removeDuplicatesWithNoDS(new LinkedList<Integer>(Arrays.asList(6,6,1,2,3,1,4,2,3,4,6,6))));
    }
}
