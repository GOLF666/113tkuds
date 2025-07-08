public class BasicArrayOperations {
    public static void main(String[] args) {
        int[] arr = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 輸出陣列長度
        System.out.println("陣列長度: " + arr.length);

        // 修改第3個元素
        arr[2] = 99;

        // 修改最後一個元素
        arr[arr.length - 1] = 100;

        // 輸出所有元素
        for (int i = 0; i < arr.length; i++) {
            System.out.println("索引 " + i + ": " + arr[i]);
        }
    }
}
