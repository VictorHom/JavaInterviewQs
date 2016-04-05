package com.company;
import java.util.*;

/**
 * Created by VictorHom on 3/25/16.
 */
public class InterviewQuestions {


    // Find the total number of beers you can drink given that you have totalAmount, the price per beer being costPerBeer,
    // and for every redeemFree number of beers you purchase, you get 1 free beers
    public static int totalBeers(int totalAmount, int costPerBeer, int redeemFree) {
        int total = 0;
        if (totalAmount >= costPerBeer * redeemFree) {
            total = total + 1 + redeemFree + totalBeers(totalAmount - (costPerBeer * redeemFree), costPerBeer, redeemFree);
        } else {
           return total + (int) Math.floor(totalAmount/costPerBeer);
        }
        return total;
    }



    // Recursive Countdown
    public static void liftOff(int count) {
        if (count == 0){
            System.out.println("lift off!");
            return;
        }
        System.out.println(count);
        liftOff(count-1);
    }

    public static double clockAngle(int hour,int minute) {
        double hourAngle = (hour / 12.0) * 360;
        double minuteAngle = (minute/ 60.0) * 360;
        double adjustmentAngle = (minute / 60.0)  * (1/12.0)* 360;
        return Math.abs(hourAngle + adjustmentAngle - minuteAngle);
    }


    // improve it on conciseness and readability
    public static int sum_intersection(int x1, int x2, int y1, int y2) {
        int total = 0;

        // no overlap 1 4 6 10 or 6 10 1 4
        if (x2 < y1  || y2 < x1) {
            return total;
        } else if (x2 > y1 || y2 > x1) { // 1 6 4 10
            // a range is inside another range
            // 4 5 1 10 or 1 10 4 5
            if ((x1 > y1 && x2 > y1 && x1 < y2 && x2 < y2 ) || (y1 > x1 && y2 > x1 && y1 < x2 && y2 < x2)) {
                if (x1 > y2) {
                    return x1 + x2;
                } else {
                    return y1 + y2;
                }
            } else {
                // prototypical case
                if (x1 < y1) {
                    for (int i = y1; i <= x2; i++) {
                        total += i;
                    }
                    return total;
                } else {
                    for  (int i = x1; i <= y2; i++) {
                        total += i;
                    }
                    return total;
                }

            }
        }
        return total;
    }

    public static int sum_intersection_v2(int x1, int x2, int y1, int y2) {
        int total = 0;

        if (x2 < y1  || y2 < x1) {
            return total;
        }

        //find the lower bound and the upper bound
        // 1 6 4 8
        // 4 8 1 6
        // 1 10 4 5
        // 4 5 1 10
        int lb, ub;
        if (x1 > y1) {
            lb = x1;
        } else {
            lb = y1;
        }

        if (x2 > y2) {
            ub = y2;
        } else {
            ub = x2;
        }

        for (;lb <= ub; lb++) {
            total = total + lb;
        }

        return total;
    }

    public static int multi_array_sum(int[][] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total = total + arr[i][j];
            }
        }
        return total;
    }

    static boolean valid(int[] arr) {
        int[] checker = new int[9];
        for (int i = 0; i < arr.length; i++) {
            if (checker[arr[i]-1] != 0) {
                return false;
            } else {
                checker[arr[i]-1] = arr[i];
            }
        }
        return true;
    }

    // check each sub array
    // check each square too!
    // n^2
    public static boolean sudokuValidator(int[][] arr) {
        // check each row
        for (int i = 0; i < arr.length; i++) {
            if (!valid(arr[i])) {
                return false;
            }
        }

        // check each column
        for (int j = 0; j < arr.length; j++) {
            int[] column = new int[9];
            for (int k = 0; k < arr.length; k++) {
                column[k] = arr[k][j];
            }
            if (!valid(column)){
                return false;
            }
        }

        for (int k = 0; k < arr.length; k=k+3) {
            for (int n = 0; n < arr.length; n = n + 3) {
                int[] box = new int[9];
                int boxIdx = 0;
                for (int j = k; j < k + 3; j++) {
                    for (int m = n; m < n + 3; m++){
                        box[boxIdx] = arr[m][j];
                        boxIdx = boxIdx + 1;
                    }
                }
                if (!valid(box)) {
                    return false;
                }
            }
        }

        return true;
    }

    // check if two numbers in sorted add up to s
    // sorted is in ascending order
    // version 1
    public static boolean pair_sum(int[] sorted, int s) {
        for (int i = 0; i < sorted.length; i++) {
            for (int j = i+1; j < sorted.length; j++) {
                if (sorted[i] + sorted[j] == s) {
                    return true;
                }
            }
        }
        return false;
    };

    public static boolean pair_sum_v2(int[] sorted, int s) {
        int lb = 0, ub = sorted.length-1;
        while(lb != ub) {
            if (sorted[lb] + sorted[ub] == s) {
                return true;
            }
            if (sorted[lb] + sorted[ub] > s) {
                ub--;
            } else {
                lb++;
            }
        }
        return false;
    }

    // check if you can add up to amount, given these denominations
    public static int coinChange(int[] denominations, int amount) {
        if (denominations.length <= 1) {
            if (denominations.length == 0){
                return 0;
            }
            if (amount % denominations[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int total = 0;
            for (int i = 0; i * denominations[0] <= amount; i++) {
                int[] slice = Arrays.copyOfRange(denominations, 1, denominations.length);
                total = total + coinChange(slice, amount - i * denominations[0]);
            }
            return total;
        }
    }



    // from, to can be start, middle, finish
    public static void towerOfHanoi(int pieces, String from, String to) {
        if (pieces == 1) {
            System.out.println("move a piece from " + from + " to " + to);
            return; //  need to remember the return in recursive void calls
        }
        String[] locations = new String[]{"start", "middle", "finish"};
        String openLocation = "middle";
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] != from && locations[i] != to) {
                openLocation = locations[i];
            }
        }

        towerOfHanoi(pieces - 1, from, openLocation);
        towerOfHanoi(1, from, to);
        towerOfHanoi(pieces - 1, openLocation, to);

    }

    // For a resizable array, use ArrayList<T>
    // Instead of constantly concatenating strings, which have to be copied over each time,
    // use StringBuffer, which just creates a resizable array
    // of all the strings, copying them back to a string only when necessary


    // a fun exercise would be to implement my own StringBuilder, HashTable, and ArrayList
    //http://javarevisited.blogspot.com/2010/10/difference-between-hashmap-and.html
    // HashMap for most part, unless thread stuff
    //http://stackoverflow.com/questions/9536077/when-should-i-use-a-hashtable-versus-a-hashmap


    // Algorithm that checks if a string has all unique characters; assume you cannot use any additional character
    // with no data structures, is it only n^2
    public static boolean isUnique(String s) {
        int len = s.length();
        int lenb = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < lenb; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //http://javarevisited.blogspot.com/2010/10/difference-between-hashmap-and.html
    // however, it seems for most part, use HashMap implementation
    //    http://stackoverflow.com/questions/9536077/when-should-i-use-a-hashtable-versus-a-hashmap
    // hashtable way / with a structure
    public static boolean isUnique_HashTable(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (map.containsKey(Character.toString(s.charAt(i)))) {
                return false;
            } else {
                map.put(Character.toString(s.charAt(i)), true);
            }
        }
        return true;
    }

    // given two strings, check if one is a permutation of the other


    // A. Another is to use a hashmap, and place one in it, then compare
    // B.  one solution is to sort each and then compare O(n) solution
    // VICTOR : be careful that you are using the right variables
    public static boolean isPerm(String s, String o) {
        if (s.length() != o.length()) {
            return false;
        }

        HashMap<String, Integer> map = new HashMap<>();
        int len = s.length();
        int lenb = o.length();
        for (int i = 0; i < len; i++) {
            String key = Character.toString(s.charAt(i));
            if (map.containsKey(key)) {
                int currentVal = map.get(key);
                map.put(key,  currentVal + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int j = 0; j < lenb; j++) {
            String key = Character.toString(o.charAt(j));
            // if the o string has other characters, it is false
            if (!map.containsKey(key)) {
                return false;
            } else {
                // getting a key where, it has already been subtracted
                if (map.get(key) == 0) {
                    return false;
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        return true;
    }

    // neater and possibly faster
    public static boolean isPerm_sort(String s, String o) {
        if (s.length() != o.length()) return false;
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);

        char[] oArr = o.toCharArray();
        Arrays.sort(oArr);

        for (int i =0; i < s.length(); i++) {
           if (sArr[i] != oArr[i]) {
               return false;
           }
        }
        return true;
    }

    // in this questions, they assume that you are using char[]
    // and given the true length of the array
    // instead of just string
    // and using the char[] means you can solve this question in-place
    // don't need to use anything extras
    // REACTO
    // EXAMPLE - [t,e,s,t,u,r,l,.,c,o,m,/,t,e,s,t,i,n,g, ,h,e,r,e]
    // [t,e,s,t,u,r,l,.,c,o,m,/,t,e,s,t,i,n,g,%, 2, 0 ,h,e,r,e]
    // there has to be a loop to look for %20
    // I can see a recursive approach that might work
    // find a %20, take everything after it  urlify substring
    // alternatively,
    // I can count all the spaces
    // create an array of the appropriate size and add on ?
    // That should be an O(n) operation

    // I think I overcomplicated my approach pg194)
    // given the true length, it means that the url char array can already take in all that it needs
    // the true length does not include the buffer space after the url ends
    public static String URLify_iterative(char[] url, int trueLength) {
        System.out.println(url.length);
        // replace each string with %20
        int numberOfSpacesAtEnd = 0;
        // number of modifications that need to be made

        // when you know that you made these mods, can return immediately
        // but this is more of an optimization
        int numberOfModifications = 0;

        // array length is a property
        // not a method call
        for (int i = trueLength; i < url.length; i++ ){
            if (url[i] == ' ') {
                numberOfSpacesAtEnd += 1;
            }
        }

        numberOfModifications = numberOfSpacesAtEnd / 2;

        // every time you find a space, you want to just
        // move to the end
        int j = trueLength - 1; // index based which is why there is -1
        int len = trueLength;
        int modifierLength = trueLength + numberOfSpacesAtEnd - 1; // index based which is why there is a -1
        while (j != 0) {
            // if this character is a string, make an update
            if (url[j] == ' ') { // this is how you check a character is a space
                System.out.println("yo is it a space");
                // loop backwards so you don't overwrite anything
                for (int i = len-1; i > j; i--) {
                    System.out.println(url);
                    url[modifierLength] = url[i];
                    modifierLength = modifierLength - 1;
                    if (i - 1 == j) {
                        url[modifierLength] = "0".charAt(0);
                        modifierLength = modifierLength - 1;
                        url[modifierLength] = "2".charAt(0);
                        modifierLength = modifierLength - 1;
                        url[modifierLength] = "%".charAt(0);
                        modifierLength = modifierLength - 1;
                    }
                }
                len = j;
                j = j - 1;

            } else {
                j = j - 1;
            }

        }

        System.out.println(url);
        return String.valueOf(url);
    }

    public static String URLify_recursive(char[] url) {
        // replace each string with %20

        return "";
    }

    // need to handle lower case and upper case
    public static boolean PalindromePermutation(String s) {
        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) ) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else if (!map.containsKey(s.charAt(i)) && s.charAt(i) != ' '){
                map.put(s.charAt(i), 1);
            }
        }
        boolean oddOne = false;
        for (Integer val : map.values()) {
            if (val %2 != 0) {
                if (oddOne) {
                    return false;
                } else {
                    oddOne = true;
                }
            }
        }

        // now to check

        return true;
    }

    // TODO : Test
    public static boolean oneAway(String s, String o) {
        // if they are greater than one length difference, absolutely false
        if (Math.abs(s.length() - o.length()) > 1) {
           return false;
        }
        // same length, check if there was one letter changed
        if (s.length() == o.length()) {
            return checkReplace(s, o);
        } else {
            // check if it was an insert/removal
            return checkRemovalInsert(s, o);
        }
    }

    public static boolean checkReplace(String s, String o) {
        boolean changed = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != o.charAt(i)) {
                if (changed) {
                    return false;
                }
                changed = true;
            }
        }
        return true;
    }

    public static boolean checkRemovalInsert(String s, String o) {
        if (s.length() > o.length()) {
            // condition is that o is less in length than s
            return checkInsert(o, s);
        } else {
            return checkInsert(s, o);
        }
    }
    // s is shorter
    public static boolean checkInsert(String s, String o) {
        int i = 0,j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == o.charAt(j)) {
                i++;
                j++;
            } else {
                // means that it already hit this case once
                if (i != j) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    // assume that only uppercase and lowercase letters
    // also if the string changed is not improved against the original s, return s instead
    public static String stringCompression(String s) {
        String result = "";
        char curr = '\0'; // :(
        int counter  = 0;
        for (int i = 0 ;i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (i == 0) {
                curr = s.charAt(i);
            }

            if (curr == s.charAt(i)) {
                counter += 1;
            } else {
                System.out.println("in here");
                result = result + Character.toString(curr) + counter;
                curr = s.charAt(i);
                counter = 1;
            }
        }
        // is there a way to not deal with this line
        result = result + Character.toString(curr) + counter;
        return result.length() > s.length() ? s : result;
    }

    // do the traversal problem - the one from codewar on spiral traversal

    // return an image represented by an n by n matrix
    // can you modify so that the image is 90 degrees

    // take 1 without doing it in place
    public static int[][] rotateMatrix(int[][] img) {
        int[][] rotatedMatrix = new int[img.length][img.length];
        int placeholder = 0;
        for (int i = img.length-1; i >= 0; i--) {
            for (int j = 0; j < img.length; j++) {
                rotatedMatrix[j][placeholder] = img[i][j];
            }
            placeholder += 1;
        }

        // for printing stuff out
        for (int k = 0; k < rotatedMatrix.length; k++) {
            System.out.println(Arrays.toString(rotatedMatrix[k]));
        }
        return rotatedMatrix;
    }

    // take 2
    // Try to do it in place, no creating a new structure
    // the mutating of the input :(
    public static int[][] zeroMatrix(int[][] ar) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        for (int i = 0; i < ar.length; i++) {
            for(int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < ar.length; i++) {
            if (row.indexOf(i) > -1) {
                for(int j = 0; j < ar[i].length; j++) {
                    ar[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < ar.length; i++) {
            for(int j = 0; j < ar[i].length; j++) {
                if (col.indexOf(j) > -1) {
                    ar[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < ar.length; k++) {
            System.out.println(Arrays.toString(ar[k]));
        }
        return ar;
    }

    // is s2 a rotation of s1
    // so waterbottle is a rotation of erbottlewat
    // constraint is that there is one call to isSubString
    public static boolean isSubString(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (s1.equals(s2.substring(i+1) + s2.substring(0, i+1))) { // equals is to check by value equality
                return true;
            }
        }
        return false;
    }

    // I misread the question, it was asking to write a method that would use the isSubstring method to check
    // the trick is this:
    // if you concatenate erbottlewat + erbottlewat => erbottlewaterbottlewat
    // the substring waterbottle is a substring now!!!?? that's preeeeetty neat

    // input is array of stock prices in a given day
    // each index is time from 9:30am when the market opens
    // you buy and sell
    // what is the greatest profit made in a day with one buy and then one sell
    public static int maxProfitInADay(int[] stockPrices) {
        int profits = 0;

        int i = 0, j = stockPrices.length-1;
        while (i != j) {
            int buyOne = stockPrices[i];
            int sellOne = stockPrices[j];
            if ((sellOne - buyOne) > 0) {
                if (profits < (sellOne - buyOne)) {
                    profits = sellOne - buyOne;
                }
                i++;
            } else {
                j--;
            }
        }

        return profits;
    }

//    This one needs to be worked on
    public static int maxProfitInAWeek(int[] stockPrices) {
        int profits = 0;

        int i = 1;
        int j =  stockPrices.length-1;
        while (i != j) {
            int[] localPrices = Arrays.copyOfRange(stockPrices, 0, i+1);
            int[] laterPrices = Arrays.copyOfRange(stockPrices, i+1, stockPrices.length);
        }
        return profits;
    }

    // given an unsorted linked list, remove the duplicates
    // this is a version where I can use a buffer;
    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> listWithDuplicates) {
        // a regular for loop will let you remove
        // noted
        ArrayList<Integer> checker = new ArrayList<>();
        for (int i = 0; i < listWithDuplicates.size(); i++) {
            if (checker.indexOf(listWithDuplicates.get(i)) != -1) {
                listWithDuplicates.remove(i);
                i = i - 1; // had to set the index properly
            } else {
                checker.add(listWithDuplicates.get(i));
            }
        }
        System.out.println("checker: " + checker);
        return listWithDuplicates;
    }

    // using no extra data structures
    // you can achieve this with a o(n^2)
    public static LinkedList<Integer> removeDuplicatesWithNoDS(LinkedList<Integer> listWithDuplicates) {
        for (int i = 0; i < listWithDuplicates.size(); i++) {
            for (int j = i + 1; j < listWithDuplicates.size(); j++) {
                if (listWithDuplicates.get(i) == listWithDuplicates.get(j)) {
                    listWithDuplicates.remove(j);
                    j = i;
                }
            }
        }
        return listWithDuplicates;
    }


    // find the kth to last element of a singly linked list
    // assuming I can't just use list.size()
    public static int removeKthToLastElement(LinkedList<Integer> list, int k) {
        // 1->2->3->4->5->6->7->8->9->10
        // k = 5, should return the value 6
        // 1->2->3->4->5->6->7->8->9->10
        // have a runnner that runs down until the end
        // go 10 - 5 + 1
        // start with an index of 0
        int tracker = 0;
        int lagger = 0;
        // need to use the iterator twice, each iterator is its own iterator
        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            listIterator.next();
            tracker = tracker + 1;
        }
        int go = tracker - k + 1;
        ListIterator<Integer> listIteratorB = list.listIterator();
        while(listIteratorB.hasNext()) {
            lagger = lagger + 1;
            if (go == lagger) {
                return listIteratorB.next();
            }
            listIteratorB.next();

        }
        return 0;
    }


}
