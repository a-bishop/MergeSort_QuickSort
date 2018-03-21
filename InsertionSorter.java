public class InsertionSorter extends Sorter {

    // Constructor just uses superclass constructor.
    public InsertionSorter(int[] od) {
        super(od);
    }

    // Method to sort the array, using Insertion Sort.
    public void sort() {
        int i = 0;
        int j = 0;
        int temp = 0;  // Temporary variable for swap

        for (i = 1; i < data.length; ++i) {
            j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && data[j] < data[j - 1]) {

                // Swap numbers[j] and numbers[j - 1]
                temp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = temp;
                --j;
            }
        }
    }
}
