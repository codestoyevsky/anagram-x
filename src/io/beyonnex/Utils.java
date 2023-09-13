package io.beyonnex;

import java.util.*;


// * To make the code more testable I moved the needed methods here
// * Anagram Definition : https://en.wikipedia.org/wiki/Anagram

public class Utils {
    public static Map<String, HashSet<String>> anagramMap = new HashMap<>();
    public static String mainInput;

    public static boolean areAnagrams(String str1, String str2) {

        // Trim and convert to lowercase
        String cleanedStr1 = str1.trim().toLowerCase();
        String cleanedStr2 = str2.trim().toLowerCase();

        // Early exit if the strings are the same
        if (cleanedStr1.equals(cleanedStr2))
            return true;

        if (cleanedStr1.length() != cleanedStr2.length()) return false;

        char[] charArray1 = cleanedStr1.toCharArray();
        char[] charArray2 = cleanedStr2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // This can be called inside areAnagrams directly, did not want to break Singleton rule (S_OLID)
    public static void addAnagrams(String key, String value) {
        HashSet<String> anagrams = anagramMap.computeIfAbsent(key, k -> new HashSet<>());
        anagrams.add(value);
    }

    public static void findAnagrams(String input, Set<String> result, Set<String> visited) {
        Set<String> anagrams = anagramMap.get(input);
        if (anagrams == null || visited.contains(input)) return;

        visited.add(input);

        List<String> filteredAnagrams = anagrams.stream()
                .filter(anagram -> !anagram.equals(mainInput) && !result.contains(anagram))
                .toList();


        result.addAll(filteredAnagrams);

        for (String anagram : filteredAnagrams) {
            findAnagrams(anagram, result, visited);
        }
    }

    public static void saveAnagrams(String str1, String str2) {
        addAnagrams(str1, str2);
        addAnagrams(str2, str1);
    }
}
