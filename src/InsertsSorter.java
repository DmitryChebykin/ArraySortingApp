public class InsertsSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        sortByInserts(numbersArray);
    }

    private static void sortByInserts(double[] numbersArray) {
        for (int i = 1; i < numbersArray.length; i++) {
            for (int j = i; (j > 0) && (numbersArray[j] < numbersArray[j - 1]); j--) {
                swap(numbersArray, j - 1, j);
            }
        }
    }
}