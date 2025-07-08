public class ArraySearcher {

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int index67 = findElement(data, 67);
        int index100 = findElement(data, 100);

        System.out.println("數字 67 的索引: " + index67);
        System.out.println("數字 100 的索引: " + index100);
    }
}
