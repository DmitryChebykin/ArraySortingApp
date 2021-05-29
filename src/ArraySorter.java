public abstract class ArraySorter {
    static void swap(double[] array, int firstElementIndex, int secondElementIndex) {
        double temp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = temp;
    }

    static int getMinNumberIndex(double[] numbersArray, int startIndex, int endIndex) {
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
}