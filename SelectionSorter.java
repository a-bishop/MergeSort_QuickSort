public class SelectionSorter extends Sorter {

    // Constructor just uses superclass constructor.
    public SelectionSorter(int[] od) {
        super(od);
    }

    // Method to sort the array using Selection Sort.
    public void sort() {
        int i, j;
        int temp;
        int indexSmallest;
        for (i = 0; i < data.length; i++) {

            // Find index of smallest remaining element
            indexSmallest = i;
            for (j = i+1; j < data.length; ++j) {

                if (data[j] < data[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            // Swap numbers[i] and numbers[indexSmallest]
            temp = data[i];
            data[i] = data[indexSmallest];
            data[indexSmallest] = temp;
        }
    }
}
