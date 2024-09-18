import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double GPA = 0.0;
        double totMajorScore = 0.0;

        Map<String, Double> gradeMap = Map.of(
            "A+", 4.5, 
            "A0", 4.0,
            "B+", 3.5,
            "B0", 3.0,
            "C+", 2.5,
            "C0", 2.0, 
            "D+", 1.5,
            "D0", 1.0,
            "F", 0.0
        );

        for (int i = 0; i < 20; ++i) {
            double subjectScore;
            String scoreName;
            sc.next();
            subjectScore = sc.nextDouble();
            scoreName = sc.next();

            if (!scoreName.equals("P")) {
                totMajorScore += subjectScore;
                GPA += subjectScore * gradeMap.get(scoreName);
            }
        }

        GPA /= totMajorScore;
        System.out.printf("%.6f", GPA);

        sc.close();
    }
}