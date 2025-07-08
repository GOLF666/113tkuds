public class ArrayStatistics {

    public static void main(String[] args) {
        int[] nums = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0, max = nums[0], min = nums[0];
        int maxIndex = 0, minIndex = 0;
        int even = 0, odd = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] % 2 == 0) even++;
            else odd++;
        }

        double avg = (double) sum / nums.length;

        int aboveAvg = 0;
        for (int num : nums) {
            if (num > avg) aboveAvg++;
        }

        System.out.println("=== 陣列統計分析 ===");
        System.out.printf("總和: %d\n平均: %.2f\n", sum, avg);
        System.out.printf("最大值: %d (索引 %d)\n", max, maxIndex);
        System.out.printf("最小值: %d (索引 %d)\n", min, minIndex);
        System.out.println("大於平均的數字數量: " + aboveAvg);
        System.out.println("偶數個數: " + even + ", 奇數個數: " + odd);
    }
}
