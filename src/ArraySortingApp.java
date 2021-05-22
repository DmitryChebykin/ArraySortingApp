public class ArraySortingApp {
    public static void main(String[] args) {
        Class<?> arraySorterClass = ArraySorterChecker.getArraySorterClass();

        ArraySorterChecker.printMethodsCheckingInfo(arraySorterClass);
    }
}