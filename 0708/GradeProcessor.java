public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }

        double average = (double) sum / scores.length;
        int aboveAverage = 0;
        for (int score : scores) {
            if (score > average) aboveAverage++;
        }

        System.out.printf("總分: %d\n", sum);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max + " (索引: " + maxIndex + ")");
        System.out.println("最低分: " + min + " (索引: " + minIndex + ")");
        System.out.println("超過平均分的學生數量: " + aboveAverage);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生 " + i + ": " + scores[i]);
        }
    }
}