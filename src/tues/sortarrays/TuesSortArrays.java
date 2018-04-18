package tues.sortarrays;

/**
 *
 * @author john
 */
public class TuesSortArrays {
    
    public static int[] createArray(int length) {
        int[] result = new int[length];
        
        for (int i = 0; i < length; i++) {
            result[i] = (int)(Math.random() * 100);
        }
        
        return result;
    }
    
    public static int[] swapLowestAtIndex(
            int startingIndex,
            int[] unsortedArray
    ) {
        int currentLowest = Integer.MAX_VALUE;
        int lowestIndex = startingIndex;
        
        for (int i = startingIndex; i < unsortedArray.length; i++) {
            if (currentLowest > unsortedArray[i]) {
                currentLowest = unsortedArray[i];
                lowestIndex = i;
            }
        }
        
        unsortedArray[lowestIndex] = unsortedArray[startingIndex];
        unsortedArray[startingIndex] = currentLowest;
        
        return unsortedArray;
    }
    
    public static int[] sortArray(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray = swapLowestAtIndex(i, unsortedArray);
        }
        
        return unsortedArray;
    }
    
    public static void printArray(int[] array) {
        System.out.print("[ ");
        
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        
        System.out.println(" ]");
    }
    
    public static int[] clone(int[] array) {
        int[] result = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] myArray = createArray(1000000);
        int[] myClonedArray = clone(myArray);
        int[] sortedArray = sortArray(myClonedArray);
        
        System.out.println("Done!");
//        printArray(sortedArray);
        
        // printArray(sortArray(clone(createArray(10))));
    }
    
}
