import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySorterChecker {
    public static Class<?> getArraySorterClass() {
        Class<?> arraySorterClass = null;

        try {
            arraySorterClass = Class.forName("ArraySorter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arraySorterClass;
    }

    private static TestData[] getDemoArrays() {
        return new TestData[]{
                new TestData(new double[]{}),
                new TestData(new double[]{1}),
                new TestData(new double[]{1, 2}),
                new TestData(new double[]{2, 1}),
                new TestData(new double[]{-1, -1}),
                new TestData(new double[]{1, 1, 1024, -2}),
                new TestData(new double[]{0, 0}),
                new TestData(new double[]{0}),
                new TestData(new double[]{1, 4, 7, 9, -5, 77, 77, 77, 44, 44, 4, -852, 67, -55, -1, 23}),
                new TestData(new double[]{-2}),
                new TestData(new double[]{-2, -4, 8, -45, -10255, 1, 2, 2, 2, 2, 3, 3, 3}),
                new TestData(new double[]{10, 2, 3, 6, 8, 7, 1, 12}),
        };
    }

    private static List<Method> getCheckMarkedMethods(Class<?> CheckingClass) {
        List<Method> methods = new ArrayList<>();

        for (Method m : CheckingClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Check.class)) {
                methods.add(m);
            }
        }

        return methods;
    }

    static void printMethodsCheckingInfo(Class<?> CheckingClass) {
        TestData[] testData = getDemoArrays();
        List<Method> methods = getCheckMarkedMethods(CheckingClass);

        for (TestData testArray : testData) {
            printHeaderMessage(testArray);

            for (Method m : methods) {
                printCheckingMessage(m, testArray);
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }

    private static void printHeaderMessage(TestData testArray) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Unsorted array: " + Arrays.toString(testArray.getUnsortedArray()));
        System.out.println("  Sorted array: " + Arrays.toString(testArray.getSortedArray()));
    }

    private static void printCheckingMessage(Method m, TestData testArray) {
        try {
            double[] checkingArray = Arrays.copyOf(testArray.getUnsortedArray(), testArray.getUnsortedArray().length); //keep TestData fields unmodified
            m.invoke(null, checkingArray);

            if (Arrays.equals(checkingArray, testArray.getSortedArray())) {
                printSuccessMessage(m, checkingArray);
            } else {
                printNotSuccessMessage(m, testArray);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void printNotSuccessMessage(Method m, TestData testArray) {
        System.out.printf("%15s is NOT SUCCESS sorting %n", (m.getName()));
    }

    private static void printSuccessMessage(Method m, double[] checkingArray) {
        System.out.printf("%15s is SUCCESS sorting %n", (m.getName()));
    }
}