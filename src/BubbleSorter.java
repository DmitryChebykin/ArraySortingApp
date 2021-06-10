public class BubbleSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        int maxIndex = numbersArray.length - 1;

        for (int i = maxIndex; i > 0; i--) {
            boolean isSorted = true;

            for (int j = 0; j < i; j++) {
                if (numbersArray[j] > numbersArray[j + 1]) {
                    swap(numbersArray, j, j + 1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}