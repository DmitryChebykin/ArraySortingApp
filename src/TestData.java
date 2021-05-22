import java.util.Arrays;

public class TestData {
    private double[] unsortedArray;
    private double[] sortedArray;

    public TestData(double[] array) {
        this.unsortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray = Arrays.copyOf(array, array.length));
    }

    public double[] getUnsortedArray() {
        return unsortedArray;
    }

    public void setUnsortedArray(double[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public double[] getSortedArray() {
        return sortedArray;
    }
}