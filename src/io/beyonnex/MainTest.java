package io.beyonnex;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MainTest {
    // Feature #1
    @Test
    public void testAreAnagrams() {
        assertTrue(Utils.areAnagrams("listen", "silent"));
        assertFalse(Utils.areAnagrams("hello", "world"));
    }

    // Feature #2
    @Test
    public void testFindAnagrams() {
        Utils.areAnagrams("1234", "4321");
        Utils.saveAnagrams("1234", "4321");

        Utils.areAnagrams("1234", "2341");
        Utils.saveAnagrams("1234", "2341");

        Utils.areAnagrams("1234", "3412");
        Utils.saveAnagrams("1234", "3412");

        Utils.areAnagrams("1234", "56789");

        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        var input = "1234";
        Utils.mainInput = input;
        Utils.findAnagrams(input, results, visited);
        Set<String> expectedResult = new HashSet<>(Arrays.asList("4321", "2341", "3412"));
        assertEquals(expectedResult, results);
    }

    // Feature #2, Complex scenario
    @Test
    public void testFindAnagramsFromRelations() {
        Utils.areAnagrams("1234", "4321");
        Utils.saveAnagrams("1234", "4321");

        Utils.areAnagrams("1234", "2341");
        Utils.saveAnagrams("1234", "2341");

        Utils.areAnagrams("1234", "3412");
        Utils.saveAnagrams("1234", "3412");

        Utils.areAnagrams("1234", "56789");

        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        var input = "2341";
        Utils.mainInput = input;
        Utils.findAnagrams(input, results, visited);
        Set<String> expectedResult = new HashSet<>(Arrays.asList("1234", "4321", "3412"));
        assertEquals(expectedResult, results);
    }
}