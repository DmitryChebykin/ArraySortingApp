import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySorterChecker {
    public static final String[] CHECKED_CLASSES = new String[]{"BubbleSorter", "HeapSorter", "InsertsSorter", "QuickSorter", "SelectionSorter"};

    public static Class<?> getCheckedClass(String className) {
        Class<?> arraySorterClass = null;

        try {
            arraySorterClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arraySorterClass;
    }

    private static TestData[] getDemoArraysSet() {
        return new TestData[]{
//                new TestData(new double[]{}),
//                new TestData(new double[]{1}),
//                new TestData(new double[]{1, 2}),
//                new TestData(new double[]{2, 1}),
//                new TestData(new double[]{-1, -1}),
//                new TestData(new double[]{1, 1, 1024, -2}),
//                new TestData(new double[]{0, 0}),
//                new TestData(new double[]{0}),
                new TestData(new double[]{1, 4, 7, 9, -5, 77, 77, 77, 44, 44, 4, -852, 67, -55, -1, 23}),
//                new TestData(new double[]{-2}),
//                new TestData(new double[]{-2, -4, 8, -45, -10255, 1, 2, 2, 2, 2, 3, 3, 3}),
//                new TestData(new double[]{10, 2, 3, 6, 8, 7, 1, 12}),
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

    static void printMethodsCheckingInfo() {
        for (String klass : CHECKED_CLASSES) {
            TestData[] testData = getDemoArraysSet();
            List<Method> methods = getCheckMarkedMethods(getCheckedClass(klass));

            for (TestData testSet : testData) {
                printHeaderMessage(testSet);

                for (Method m : methods) {
                    printCheckingMessage(m, testSet);
                }

                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    private static void printHeaderMessage(TestData testData) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Unsorted array: " + Arrays.toString(testData.getUnsortedArray()));
        System.out.println("  Sorted array: " + Arrays.toString(testData.getSortedArray()));
    }

    private static void printCheckingMessage(Method m, TestData testArray) {
        try {
            double[] sortedArray = Arrays.copyOf(testArray.getUnsortedArray(), testArray.getUnsortedArray().length); //keep TestData fields unmodified
            m.invoke(null, sortedArray);

            if (Arrays.equals(sortedArray, testArray.getSortedArray())) {
                printSuccessMessage(m);
            } else {
                printNotSuccessMessage(m, sortedArray);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void printNotSuccessMessage(Method m, double[] resultArray) {
        System.out.printf("!!! NOT SUCCESS sorting -  %15s : %s%n", (m.getDeclaringClass() + "." + m.getName()), Arrays.toString(resultArray));
    }

    private static void printSuccessMessage(Method m) {
        System.out.printf("%15s is SUCCESS sorting %n", m.getDeclaringClass() + "." + m.getName());
    }
}