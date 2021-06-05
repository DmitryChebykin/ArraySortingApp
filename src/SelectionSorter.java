public class SelectionSorter extends ArraySorter {
    @Check
    private static void sort(double[] numbersArray) {
        for (int i = 0; i < numbersArray.length; i++) {
            double minValue = numbersArray[i];
            int minNumberIndex = i;

            for (int j = i + 1; j < numbersArray.length; j++) {
                if (numbersArray[j] < minValue) {
                    minNumberIndex = j;
                    minValue = numbersArray[j];
                }
            }

            swap(numbersArray, i, minNumberIndex);
        }
    }
}