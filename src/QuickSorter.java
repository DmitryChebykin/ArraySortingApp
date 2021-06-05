public class QuickSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        quickSortByRecursion(numbersArray, 0, numbersArray.length - 1);
    }

    private static void quickSortByRecursion(double[] numbersArray, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }

        int i = fromIndex;
        int j = toIndex;

        double baseValue = numbersArray[i + (j - i) / 2];

        while (i <= j) {
            while (numbersArray[i] < baseValue) {
                i++;
            }

            while (numbersArray[j] > baseValue) {
                j--;
            }

            if (i <= j) {
                swap(numbersArray, i, j);
                i++;
                j--;
            }
        }

        quickSortByRecursion(numbersArray, fromIndex, j);

        quickSortByRecursion(numbersArray, i, toIndex);
    }
}