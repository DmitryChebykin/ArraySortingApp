import java.util.Scanner;

public class ArraySortingApp {
    public static void main(String[] args) {

        System.out.println("Номера сортировок:");
        System.out.println("BubbleSorter    - 0");
        System.out.println("HeapSorter      - 1");
        System.out.println("InsertsSorter   - 2");
        System.out.println("QuickSorter     - 3");
        System.out.println("SelectionSorter - 4");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер сортировки для проверки:");
        int number = scanner.nextInt();

        String[] classesNames = new String[]{
                "BubbleSorter",
                "HeapSorter",
                "InsertsSorter",
                "QuickSorter",
                "SelectionSorter"};

        new ArraySorterChecker(new String[]{classesNames[number]}).printMethodsCheckingInfo();
    }
}