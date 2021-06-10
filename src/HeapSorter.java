public class HeapSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        int lastIndex = numbersArray.length - 1;
        if (lastIndex < 0) {
            return;
        }

        buildHeap(numbersArray);
        swap(numbersArray, 0, lastIndex);

        for (int i = lastIndex - 1; i > 0; i--) {
            heapifyParent(numbersArray, 0, i);
            swap(numbersArray, 0, i);
        }
    }

    private static void buildHeap(double[] numbersArray) {
        int lastIndex = numbersArray.length - 1;
        int mediumIndex = numbersArray.length / 2 - 1;

        for (int i = mediumIndex; i >= 0; i--) {
            heapifyParent(numbersArray, i, lastIndex);
        }
    }

    private static void heapifyParent(double[] numbersArray, int parentIndex, int lastIndex) {
        int examinedParentIndex = parentIndex;

        while (isLeftChildExist(examinedParentIndex, lastIndex)) {
            int leftChildIndex = examinedParentIndex * 2 + 1;
            int rightChildIndex = isRightChildExist(examinedParentIndex, lastIndex)
                    ? examinedParentIndex * 2 + 2
                    : leftChildIndex;
            int swappedChildIndex = numbersArray[leftChildIndex] > numbersArray[rightChildIndex]
                    ? leftChildIndex
                    : rightChildIndex;

            if (numbersArray[examinedParentIndex] >= numbersArray[swappedChildIndex]) {
                break;
            }

            swap(numbersArray, examinedParentIndex, swappedChildIndex);
            examinedParentIndex = swappedChildIndex;
        }
    }

    private static boolean isLeftChildExist(int elementIndex, int lastIndex) {
        return 2 * elementIndex + 1 <= lastIndex;
    }

    private static boolean isRightChildExist(int elementIndex, int lastIndex) {
        return 2 * elementIndex + 2 <= lastIndex;
    }
}