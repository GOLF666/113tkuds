public class IsSorted {
    
    // 遞迴檢查陣列是否為升序排列
    public static boolean isSorted(int[] arr, int index) {
        // 停止條件：若只剩一個元素或沒有元素，就視為已排序
        if (index == arr.length - 1) {
            return true;
        }

        // 若當前元素大於下一個，則不是升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一組元素
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 3, 2, 1};
        int[] arr3 = {10};

        System.out.println("arr1 是否排序？" + isSorted(arr1, 0)); // true
        System.out.println("arr2 是否排序？" + isSorted(arr2, 0)); // false
        System.out.println("arr3 是否排序？" + isSorted(arr3, 0)); // true
    }
}