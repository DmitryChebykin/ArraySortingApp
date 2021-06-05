public class SelectionSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortBySelection(numbersArray);
    }

    private static void sortBySelection(double[] numbersArray) {
        int endIndex = numbersArray.length - 1;

        for (int i = 0; i <= endIndex; i++) {
            double minValue = numbersArray[i];
            int minNumberIndex = i;

            for (int j = i + 1; j <= endIndex; j++) {
                if (numbersArray[j] < minValue) {
                    minNumberIndex = j;
                    minValue = numbersArray[j];
                }
            }

            swap(numbersArray, i, minNumberIndex);
        }
    }
}