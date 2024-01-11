import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperations {

    public static Set<Character> getSetInput(String setName) {
        Set<Character> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements for set " + setName + " (type 'done' when finished):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            char element = input.charAt(0);
            set.add(element);
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Set<Character> setA = getSetInput("A");
            Set<Character> setB = getSetInput("B");

            // Perform set operations
            Set<Character> union = new HashSet<>(setA);
            union.addAll(setB);

            Set<Character> intersection = new HashSet<>(setA);
            intersection.retainAll(setB);

            Set<Character> differenceA = new HashSet<>(setA);
            differenceA.removeAll(setB);

            Set<Character> differenceB = new HashSet<>(setB);
            differenceB.removeAll(setA);

            // Print results
            System.out.println("\nSet A: " + setA);
            System.out.println("Set B: " + setB);
            System.out.println("Union (A ∪ B): " + union);
            System.out.println("Intersection (A ∩ B): " + intersection);
            System.out.println("Difference (A - B): " + differenceA);
            System.out.println("Difference (B - A): " + differenceB);

            // Ask if the user wants to continue
            System.out.print("\nDo you want to perform another operation? (yes/no): ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}