package pkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class UpperBoundWildCard<T extends Number> {
    private List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    public List<T> getNumbers() {
        return numbers;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UpperBoundWildCard<Integer> intList = new UpperBoundWildCard<>();
        UpperBoundWildCard<Double> doubleList = new UpperBoundWildCard<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Integer");
            System.out.println("2. Add Double");
            System.out.println("3. Sum Integers");
            System.out.println("4. Sum Doubles");
            System.out.println("5. Sort Integers");
            System.out.println("6. Sort Doubles");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    intList.add(getInput(scanner, "integer"));
                    break;
                case 2:
                    doubleList.add(getInput(scanner, "double"));
                    break;
                case 3:
                    System.out.println("Sum of Integers: " + sum(intList.getNumbers()));
                    break;
                case 4:
                    System.out.println("Sum of Doubles: " + sum(doubleList.getNumbers()));
                    break;
                case 5:
                    sortAndPrint(intList.getNumbers());
                    break;
                case 6:
                    sortAndPrint(doubleList.getNumbers());
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static <T extends Number> T getInput(Scanner scanner, String type) {
        System.out.print("Enter a " + type + ": ");
        return (T) (type.equals("integer") ? Integer.valueOf(scanner.nextInt()) : Double.valueOf(scanner.nextDouble()));
    }

    private static <T extends Comparable<T>> void sortAndPrint(List<T> list) {
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
    }

    private static <T extends Number> double sum(List<T> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}
