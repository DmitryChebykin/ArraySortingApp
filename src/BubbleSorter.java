public class BubbleSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortByBubble(numbersArray);
    }

    private static void sortByBubble(double[] numbersArray) {
        int replaceCount = 0;
        int j = numbersArray.length;

        while (j != 1) {
            for (int i = 0; i < j - 1; i++) {
                if (numbersArray[i] > numbersArray[i + 1]) {
                    swap(numbersArray, i, i + 1);
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
}