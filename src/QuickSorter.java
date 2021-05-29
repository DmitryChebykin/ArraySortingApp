public class QuickSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        quickSort(numbersArray);
    }

    private static void quickSort(double[] numbersArray) {
        int from = 0;
        int to = numbersArray.length - 1;
        quickSortByRecursion(numbersArray, from, to);
    }

    private static void quickSortByRecursion(double[] numbersArray, int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            int leftIndex = fromIndex;
            int rightIndex = toIndex;
            double baseValue = numbersArray[leftIndex + (rightIndex - leftIndex) / 2];

            while (leftIndex < rightIndex) {
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
}