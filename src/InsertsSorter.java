public class InsertsSorter extends ArraySorter {
    @Check
    public static void sort(double[] numbersArray) {
        for (int i = 1; i < numbersArray.length; i++) {
            double temp = numbersArray[i];
            int j = i - 1;

            while (j >= 0 && numbersArray[j] > temp) {
                numbersArray[j + 1] = numbersArray[j];
                j--;
            }

            numbersArray[j + 1] = temp;
        }
    }
}