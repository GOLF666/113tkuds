import java.util.Random;
public class ds_06 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random r = new Random();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
            if (nums[i] > max) max = nums[i];
        }
        System.out.println("陣列最大值為：" + max);
    }
}
