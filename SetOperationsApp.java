import java.util.HashSet; // Importing packages
import java.util.Scanner;
import java.util.Set;
import java.util.Collections; // Import Collections class for disjoint method.

public class SetOperationsApp { // Create a class to handle the creation of HashSets (Sets)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> setA = new HashSet<>(); // Creation of HashSet variable setA
        Set<Character> setB = new HashSet<>(); // Creation of HashSet variable setB

        while (true) { // While true..
            System.out.println("Enter 'A' or 'B' to add elements, 'D' for difference, 'I' for is_disjoint, 'C' for cardinality, or 'S' to stop:"); // System prints out char variable selection for setA or setB.
            String input = scanner.nextLine(); // Code gathers input from the user.

            if (input.equalsIgnoreCase("A")) { // If user inputs 'A or a', the code below prints...
                System.out.println("Enter an element for set A:"); // This asks the user what elements they'd like in the set.
                char element = scanner.nextLine().charAt(0);
                setA.add(element); // Proceeds to add the elements.
            } else if (input.equalsIgnoreCase("B")) { // Else if the user inputs 'B or b', the same procedures occur.
                System.out.println("Enter an element for set B:");
                char element = scanner.nextLine().charAt(0);
                setB.add(element);
            } else if (input.equalsIgnoreCase("D")) { // Else if the user inputs 'D or d', the code below prints...
                Set<Character> differenceResult = difference(setA, setB); // Calls the difference method.
                System.out.println("Difference (A - B): " + differenceResult); // Prints the difference result.
            } else if (input.equalsIgnoreCase("I")) { // Else if the user inputs 'I or i', the code below prints...
                boolean isDisjointResult = isDisjoint(setA, setB); // Calls the isDisjoint method.
                System.out.println("Is Disjoint: " + isDisjointResult); // Prints the isDisjoint result.
            } else if (input.equalsIgnoreCase("C")) { // Else if the user inputs 'C or c', the code below prints...
                int cardinalityResultA = cardinality(setA); // Calls the cardinality method for set A.
                int cardinalityResultB = cardinality(setB); // Calls the cardinality method for set B.
                System.out.println("Cardinality of set A: " + cardinalityResultA); // Prints the cardinality of set A.
                System.out.println("Cardinality of set B: " + cardinalityResultB); // Prints the cardinality of set B.
            } else if (input.equalsIgnoreCase("S")) { // Else if the user inputs 'S or s', the code breaks (exits).
                break;
            } else { // If the user inputs anything that isn't in the criteria for our char variables, the system prompts it as 'Invalid'.
                System.out.println("Invalid input. Please enter 'A', 'B', 'D', 'I', 'C', or 'S'.");
            }
        }

        Set<Character> unionResult = union(setA, setB); // Parameters for union.
        Set<Character> intersectionResult = intersection(setA, setB); // Parameters for intersection.

        System.out.println("Set A: " + setA); // Prints setA.
        System.out.println("Set B: " + setB); // Prints setB.
        System.out.println("Union: " + unionResult); // Prints both lists together.
        System.out.println("Intersection: " + intersectionResult); // Prints intersecting values.
    }

    public static Set<Character> union(Set<Character> setA, Set<Character> setB) { // Creates a set including both sets.
        Set<Character> result = new HashSet<>(setA); // Creates a new HashSet calling setA.
        result.addAll(setB); // addAll (adds elements of setA with setB).
        return result; // Returns the result.
    }

    public static Set<Character> intersection(Set<Character> setA, Set<Character> setB) {
        Set<Character> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
    }

    public static Set<Character> difference(Set<Character> setA, Set<Character> setB) { // Creates a set including both sets.
        Set<Character> result = new HashSet<>(setA); // Creates a new HashSet calling setA.
        result.removeAll(setB); // removeAll (removes elements of setA with setB).
        return result; // Returns result.
    }

    public static boolean isDisjoint(Set<Character> setA, Set<Character> setB) {
        return Collections.disjoint(setA, setB);
    }

    public static int cardinality(Set<Character> set) {
        return set.size();
    }
}