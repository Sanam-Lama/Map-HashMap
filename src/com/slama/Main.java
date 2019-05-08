package com.slama;

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


    }

    /* Given an array of strings, return a Map<String, Integer> containing a key for every different
     * string in the array, always with the value 0. For example the string "hello" makes the pair
     * "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
     */

    public Map<String, Integer> word0(String[] strings) {

        Map<String, Integer> map = new HashMap();
        for(String s : strings){
            map.put(s, 0);
        }
        return map;

    }

    /* Given an array of strings, return a Map<String, Integer> containing a key for every different
     * string in the array, and the value is that string's length.
     *
     * wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
     * wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
     * wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
     * */

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap();

        for(String s :strings) {
            map.put(s, s.length());
        }
        return map;
    }

    /* Given an array of non-empty strings, create and return a Map<String, String> as follows:
     * for each string add its first character as a key with its last character as the value.

     * pairs(["code", "bug"]) → {"b": "g", "c": "e"}
     * pairs(["man", "moon", "main"]) → {"m": "n"}
     * pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
     * */

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap();

        for(String s : strings) {
            map.put(s.substring(0,1), s.substring(s.length()-1));
        }
        return map;
    }

    /* The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
     * with a key for each different string, with the value the number of times that string appears
     * in the array.

     * wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
     * wordCount(["c", "c", "c", "c"]) → {"c": 4}
     * */

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap();

        for(String s : strings) {
            if(!map.containsKey(s)) {   // first time we've seen this string
                map.put(s, 1);
            }
            else {
                int count = map.get(s);
                map.put(s, count+1);
            }
        }
        return map;
    }

    /* Given an array of strings, return a Map<String, Boolean> where each different string is a key
     * and its value is true if that string appears 2 or more times in the array.

     * wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
     * wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     * */

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap();

        for(String s : strings) {
            if(!map.containsKey(s)) {
                map.put(s, false);
            }
            else {
                map.put(s, true);
            }
        }
        return map;
    }

    /* We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
     * Loop over and then return the given array of non-empty strings as follows: if a string matches
     * an earlier string in the array, swap the 2 strings in the array. When a position in the array
     * has been swapped, it no longer matches anything. Using a map, this can be solved making just
     * one pass over the array. More difficult than it looks.

     * allSwap(["ab", "ac"]) → ["ac", "ab"]
     * allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
     * allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]*/

    public String[] allSwap(String[] strings) {
        String[] result = new String[strings.length];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i < strings.length; i++) {
            char c = strings[i].charAt(0);
            if(map.containsKey(c)) {
                int position = map.get(c);
                map.remove(c);

                result[i] = result[position];
                result[position] = strings[i];
            }
            else {
                result[i] = strings[i];
                map.put(c,i);
            }
        }
        return result;
    }




}
