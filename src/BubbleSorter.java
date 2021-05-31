public class BubbleSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortByBubble(numbersArray);
    }

    private static void sortByBubble(double[] numbersArray) {
        for (int j = numbersArray.length; j > 0; j--) {
            boolean isSorted = true;

            for (int i = 0; i < j - 1; i++) {
                if (numbersArray[i] > numbersArray[i + 1]) {
                    swap(numbersArray, i, i + 1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}