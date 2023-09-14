package io.beyonnex;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MainTest {
    // Feature #1
    @Test
    public void shouldReturnTrueForAnagrams() {
        assertTrue(Utils.areAnagrams("listen", "silent"));
    }

    @Test
    public void shouldReturnFalseForAnagrams() {
        assertFalse(Utils.areAnagrams("hello", "world"));
    }

    // Feature #2
    @Test
    public void shouldFindAnagrams() {
        Utils.areAnagrams("1234", "4321");
        Utils.areAnagrams("1234", "2341");
        Utils.areAnagrams("1234", "3412");

        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Utils.input = "1234";

        Utils.findAnagrams(Utils.input, results, visited);
        Set<String> expectedResult = new HashSet<>(Arrays.asList("2341", "4321", "3412"));
        assertEquals(expectedResult, results);
    }

    // Feature #2
    @Test
    public void shouldNotFindAnyAnagramsForNonAnagramInput() {
        Utils.areAnagrams("1234", "4321");
        Utils.areAnagrams("1234", "2341");
        Utils.areAnagrams("1234", "5555");

        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Utils.input = "5555";

        Utils.findAnagrams(Utils.input, results, visited);
        Set<String> expectedResult = new HashSet<>();
        assertEquals(expectedResult, results);
    }

    // Feature #2, Complex scenario
    @Test
    public void shouldFindAnagramsFromRelatedTexts() {
        Utils.areAnagrams("1234", "2341");
        Utils.areAnagrams("1234", "3412");
        Utils.areAnagrams("1234", "4321");

        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Utils.input = "2341";
        Utils.findAnagrams(Utils.input, results, visited);
        Set<String> expectedResult = new HashSet<>(Arrays.asList("1234", "4321", "3412"));
        assertEquals(expectedResult, results);
    }
}