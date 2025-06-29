public class ds_05 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 2, 8, 10, 12, 14, 6, 4};
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("總和是：" + sum);
    }
}
