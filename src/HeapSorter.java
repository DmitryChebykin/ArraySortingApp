public class HeapSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        heapSort(numbersArray);
    }

    private static void heapSort(double[] numbersArray) {
        int lastIndex = numbersArray.length - 1;
        if (lastIndex < 0) {
            return;
        }

        buildHeap(numbersArray, lastIndex);
        swap(numbersArray, 0, lastIndex);

        for (int i = lastIndex - 1; i > 0; i--) {
            heapifyParent(numbersArray, 0, i);
            swap(numbersArray, 0, i);
        }
    }

    private static void buildHeap(double[] numbersArray, int lastIndex) {
        int mediumIndex = (lastIndex + 1) / 2 - 1;

        for (int i = mediumIndex; i >= 0; i--) {
            heapifyParent(numbersArray, i, lastIndex);
        }
    }

    private static void heapifyParent(double[] numbersArray, int parentIndex, int lastIndex) {
        int parent = parentIndex;

        while (isLeftChildExist(parent, lastIndex)) {
            int leftChildIndex = parent * 2 + 1;
            int rightChildIndex = (isRightChildExist(parent, lastIndex)) ? parent * 2 + 2 : leftChildIndex;
            int swapIndex = (numbersArray[leftChildIndex] > numbersArray[rightChildIndex]) ? leftChildIndex : rightChildIndex;

            if (!(numbersArray[parent] < numbersArray[swapIndex])) {
                break;
            } else {
                swap(numbersArray, parent, swapIndex);
                parent = swapIndex;
            }
        }
    }

    private static boolean isLeftChildExist(int elementIndex, int lastIndex) {
        return (2 * elementIndex + 1) <= lastIndex;
    }

    private static boolean isRightChildExist(int elementIndex, int lastIndex) {
        return (2 * elementIndex + 2) <= lastIndex;
    }
}