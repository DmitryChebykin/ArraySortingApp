public class QuickSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        quickSort(numbersArray);
    }

    private static void quickSort(double[] numbersArray) {
        quickSortByRecursion(numbersArray, 0, numbersArray.length - 1);
    }

    private static void quickSortByRecursion(double[] numbersArray, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }

        int leftIndex = fromIndex;
        int rightIndex = toIndex;

        double baseValue = numbersArray[leftIndex + (rightIndex - leftIndex) / 2];

        while (leftIndex <= rightIndex) {
            while (numbersArray[leftIndex] < baseValue) {
                leftIndex++;
            }

            while (numbersArray[rightIndex] > baseValue) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(numbersArray, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        quickSortByRecursion(numbersArray, fromIndex, rightIndex);

        quickSortByRecursion(numbersArray, leftIndex, toIndex);
    }
}