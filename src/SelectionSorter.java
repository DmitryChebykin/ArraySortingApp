public class SelectionSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortBySelection(numbersArray);
    }

    private static void sortBySelection(double[] numbersArray) {
        int endIndex = numbersArray.length - 1;

        for (int i = 0; i < endIndex; i++) {
            double minValue = numbersArray[endIndex];
            int minNumberIndex1 = endIndex;

            for (int j = i; j < endIndex; j++) {
                if (numbersArray[j] < minValue) {
                    minNumberIndex1 = j;
                    minValue = numbersArray[j];
                }
            }

            int minNumberIndex = minNumberIndex1;
            swap(numbersArray, i, minNumberIndex);
        }
    }
}