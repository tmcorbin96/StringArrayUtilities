package com.zipcodewilmington;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        if (Arrays.stream(array).anyMatch(value:: equals)) {
            return true;
        }else {
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        ArrayList<String> newArray = new ArrayList<>();
        for  (int i =array.length - 1; i>=0; i--) {
            newArray.add(array[i]);
        }
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for (int i = 0; i< array.length; i++) {
            for( int j = array.length-1; i>=0; i--) {
                if (array[i]==array[j]) {
                    return true;
                } else {}
            }break;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String newArray = Arrays.toString(array);
        String abc = "abcdefghijklmnopqrxtuvwxyzABCDEFGHIJKLMNOPQRXTUVWXYZ";
        newArray = newArray.replace(" ", "");
       // StringBuilder comp = new StringBuilder();
        for (int i =0; i<abc.length(); i++) {
            for(int j = 0; j < newArray.length(); j++) {
                if (abc.charAt(i)==newArray.charAt(j)) {
                  //  comp.append(abc.charAt(i));
                }
            }
        }

        return newArray.toLowerCase()
                .replaceAll("[^a-z]", "")
                .replaceAll("(.)(?=.*\\1)", "")
                .length() == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        String newArray = Arrays.toString(array);
        // changes string [] to string
        String newString [] = newArray.replaceAll("\\p{Punct}", "").split(" ");
        //creates newString from newArray after having all punctuation removed and adding spaces.
        int count = 0;

        for (int i=0; i < newString.length; i++) {
            if (value.equals(newString[i]))
           count++;

        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       ArrayList<String> newArray = new ArrayList(Arrays.asList(array));
       newArray.remove(valueToRemove);
       String[] newValue = newArray.toArray(new String[0]);

        return newValue;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<String>();
        Set<String> set = new HashSet<>(newArray);
        // newArray.clear();
       // for (String s : array) {
            newArray.add(array[0]);
            for (int i = 1; i<array.length; i++) {
                if (!array[i].equals(array[i-1])) {
                    newArray.add(array[i]);
                }
            }

            String[] removal =new String[newArray.size()];
            removal = newArray.toArray(removal);

        return removal;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> dupe = new ArrayList();
        for (int i=0; i< array.length; i++) {
            dupe.add(i, array[i]);
        }
        for (int i = 0; i < dupe.size()-1; i++) {
            while(dupe.get(i).contains((dupe.get(i+1)))) {
                dupe.set(i, (dupe.get(i) + dupe.get(i+1)));
                dupe.remove(i+1);
                if (i== dupe.size()-1) {
                    break;
                }
            }
        }
        String[] pack = new String[dupe.size()];
        pack = dupe.toArray(pack);
        return pack;
    }


}
