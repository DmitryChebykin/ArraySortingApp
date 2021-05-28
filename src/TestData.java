import java.util.Arrays;

public class TestData {
    private double[] unsortedArray;
    private double[] sortedArray;

    public TestData(double[] array) {
        unsortedArray = Arrays.copyOf(array, array.length);
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    public double[] getUnsortedArray() {
        return unsortedArray;
    }

    public void setUnsortedArray(double[] array) {
        unsortedArray = Arrays.copyOf(array, array.length);
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    public double[] getSortedArray() {
        return sortedArray;
    }
}