public class MergeSorter extends Sorter {

   public MergeSorter(int[] data) {
      super(data);
   }

   protected static void merge(int[] data, int i, int j, int k) {
      int mergedSize = k - i + 1;       // Size of merged partition
      int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
      int mergePos = 0;                 // Position to insert merged number
      int leftPos = 0;                  // Position of elements in left partition
      int rightPos = 0;                 // Position of elements in right partition

      leftPos = i;                      // Initialize left partition position
      rightPos = j + 1;                 // Initialize right partition position

      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= j && rightPos <= k) {
         if (data[leftPos] < data[rightPos]) {
            mergedNumbers[mergePos] = data[leftPos];
            ++leftPos;
         }
         else {
            mergedNumbers[mergePos] = data[rightPos];
            ++rightPos;
         }
         ++mergePos;
      }

      // If left partition is not empty, add remaining elements to merged numbers
      while (leftPos <= j) {
         mergedNumbers[mergePos] = data[leftPos];
         ++leftPos;
         ++mergePos;
      }

      // If right partition is not empty, add remaining elements to merged numbers
      while (rightPos <= k) {
         mergedNumbers[mergePos] = data[rightPos];
         ++rightPos;
         ++mergePos;
      }

      // Copy merge number back to numbers
      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
         data[i + mergePos] = mergedNumbers[mergePos];
      }
   }

   protected void sort(int[] data, int i, int k) {
      int j = 0;

      if (i < k) {
         j = (i + k) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         sort(data, i, j);
         sort(data, j + 1, k);

         // Merge left and right partition in sorted order
         merge(data, i, j, k);
      }
   }

   public void sort() {
      sort(data, 0, data.length-1);
   }
}
