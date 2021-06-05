public abstract class ArraySorter {
    static void swap(double[] array, int firstElementIndex, int secondElementIndex) {
        double temp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = temp;
    }
}