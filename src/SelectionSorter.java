public class SelectionSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortBySelection(numbersArray);
    }

    private static void sortBySelection(double[] numbersArray) {
        int endIndex = numbersArray.length - 1;

        for (int i = 0; i < endIndex; i++) {
            int minNumberIndex = getMinNumberIndex(numbersArray, i, endIndex);
            swap(numbersArray, i, minNumberIndex);
        }
    }
}