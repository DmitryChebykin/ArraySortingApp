public class SelectionSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        int lastCheckingIndex = numbersArray.length - 1;

        for (int i = 0; i < lastCheckingIndex; i++) {
            int minNumberIndex = i;

            for (int j = i + 1; j < numbersArray.length; j++) {
                if (numbersArray[j] < numbersArray[minNumberIndex]) {
                    minNumberIndex = j;
                }
            }

            swap(numbersArray, i, minNumberIndex);
        }
    }
}