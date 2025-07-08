public class StudentGradeSystem {

    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];

        int aCount = 0, bCount = 0, cCount = 0, dCount = 0;
        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            grades[i] = getGrade(scores[i]);
            sum += scores[i];

            switch (grades[i]) {
                case 'A' -> aCount++;
                case 'B' -> bCount++;
                case 'C' -> cCount++;
                case 'D' -> dCount++;
            }

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
        int aboveAvgCount = 0;
        for (int score : scores) {
            if (score > average) aboveAvgCount++;
        }

        // 輸出
        System.out.println("==== 學生成績報告 ====");
        System.out.printf("全班平均: %.2f\n", average);
        System.out.println("最高分: " + max + " (學生 " + maxIndex + ")");
        System.out.println("最低分: " + min + " (學生 " + minIndex + ")");
        System.out.println("高於平均人數: " + aboveAvgCount);
        System.out.println("--- 等級統計 ---");
        System.out.println("A 等: " + aCount);
        System.out.println("B 等: " + bCount);
        System.out.println("C 等: " + cCount);
        System.out.println("D 等: " + dCount);
        System.out.println("----- 詳細列表 -----");
        System.out.println("編號\t分數\t等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "\t" + scores[i] + "\t" + grades[i]);
        }
    }
}
