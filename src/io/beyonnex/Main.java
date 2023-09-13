package io.beyonnex;

import java.util.*;

import static io.beyonnex.Utils.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an action:");
            System.out.println("1 - Check if two texts are anagrams of each other.");
            System.out.println("2 - Show all anagrams for a given text.");
            System.out.println("3 - Exit the program.");

            int choice = scanner.nextInt();

            // Consume the newline character left in the input buffer
            scanner.nextLine();

            switch (choice) {
                // Feature #1
                case 1 -> {
                    System.out.println("Enter the first text:");
                    String str1 = scanner.nextLine();
                    System.out.println("Enter the second text:");
                    String str2 = scanner.nextLine();
                    boolean areAnagrams = areAnagrams(str1, str2);
                    System.out.printf("These texts %s anagrams%n", areAnagrams ? "are" : "are not");
                    if (areAnagrams) {
                        Utils.saveAnagrams(str1, str2);
                    }
                }
                // Feature #2
                case 2 -> {
                    System.out.println("Enter a text to find anagrams:");
                    String input = scanner.nextLine();

                    Set<String> result = new HashSet<>();
                    Set<String> visited = new HashSet<>();

                    var cleanedInput = input.trim().toLowerCase();
                    mainInput = cleanedInput;

                    findAnagrams(cleanedInput, result, visited);

                    if (result.isEmpty()) {
                        System.out.println("No anagrams found for the given text.");
                    } else {
                        System.out.println("Anagrams for " + input + ": " + result);
                    }
                }
                case 3 -> {
                    exit = true;
                    System.out.println("Exiting the program.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

}
