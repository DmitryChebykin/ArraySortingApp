public class ArraySorter {
    @Check
    public static void heapSort(double[] numbersArray) {
        int lastIndex = numbersArray.length - 1;

        for (int i = lastIndex; i > 0; i--) {
            rearrangeForHeapStructure(numbersArray, i);
            swapTwoArrayElements(numbersArray, 0, i);
        }
    }

    private static void rearrangeForHeapStructure(double[] numbersArray, int lastIndex) {
        int mediumIndex = (lastIndex + 1) / 2 - 1;

        for (int i = mediumIndex; i >= 0; i--) {
            swapParentForHeap(numbersArray, i, lastIndex);
        }
    }

    private static void swapParentForHeap(double[] numbersArray, int parentIndex, int lastIndex) {
        int parent = parentIndex;

        while (isLeftChildExist(numbersArray, parent, lastIndex)) {
            int leftChildIndex = parent * 2 + 1;

            if (!(numbersArray[parent] < numbersArray[leftChildIndex])) {
                break;
            } else {
                swapTwoArrayElements(numbersArray, parent, leftChildIndex);
                parent = leftChildIndex;
            }
        }

        parent = parentIndex;

        while (isRightChildExist(numbersArray, parent, lastIndex)) {
            int rightChildIndex = parent * 2 + 2;

            if (!(numbersArray[parent] < numbersArray[rightChildIndex])) {
                break;
            } else {
                swapTwoArrayElements(numbersArray, parent, rightChildIndex);
                parent = rightChildIndex;
            }
        }
    }

    @Check
    public static void quickSort(double[] numbersArray) {
        int from = 0;
        int to = numbersArray.length - 1;
        quickSortByRecursion(numbersArray, from, to);
    }

    public static void quickSortByRecursion(double[] numbersArray, int fromIndex, int toIndex) {
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
                    swapTwoArrayElements(numbersArray, leftIndex, rightIndex);
                    leftIndex++;
                    rightIndex--;
                }
            }

            quickSortByRecursion(numbersArray, fromIndex, rightIndex);

            quickSortByRecursion(numbersArray, leftIndex, toIndex);
        }
    }

    @Check
    public static void sortByInserts(double[] numbersArray) {
        for (int i = 1; i < numbersArray.length; i++) {
            for (int j = i; (j > 0) && (numbersArray[j] < numbersArray[j - 1]); j--) {
                swapTwoArrayElements(numbersArray, j - 1, j);
            }
        }
    }

    @Check
    public static void sortByBubble(double[] numbersArray) {
        int replaceCount = 0;
        int j = numbersArray.length;

        while (j != 1) {
            for (int i = 0; i < j - 1; i++) {
                if (numbersArray[i] > numbersArray[i + 1]) {
                    swapTwoArrayElements(numbersArray, i, i + 1);
                    replaceCount++;
                }
            }

            if (replaceCount == 0) {
                j = 1;
            } else {
                j--;
            }
        }
    }

    @Check
    public static void sortBySelection(double[] numbersArray) {
        int endIndex = numbersArray.length - 1;

        for (int i = 0; i < numbersArray.length - 1; i++) {
            int minNumberIndex = getMinNumberIndex(numbersArray, i, endIndex);
            swapTwoArrayElements(numbersArray, i, minNumberIndex);
        }
    }

    private static void swapTwoArrayElements(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int getMinNumberIndex(double[] numbersArray, int startIndex, int endIndex) {
        double minValue = numbersArray[endIndex];
        int minNumberIndex = endIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (numbersArray[i] < minValue) {
                minNumberIndex = i;
                minValue = numbersArray[i];
            }
        }

        return minNumberIndex;
    }

    private static boolean isLeftChildExist(double[] numbersArray, int elementIndex, int lastIndex) {
        return (2 * elementIndex + 1) <= lastIndex;
    }

    private static boolean isRightChildExist(double[] numbersArray, int elementIndex, int lastIndex) {
        return (2 * elementIndex + 2) <= lastIndex;
    }
}