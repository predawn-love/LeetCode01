package myleetcode.one_question_perday;

import java.util.Random;

public class Q478GenerateRandomPointInACircle {

}
class c{
    class Solution {
        Random random;
        double radius, x_center, y_center;

        public Solution(double radius, double x_center, double y_center) {
            random = new Random();
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * 2 * radius - radius;
                double y = random.nextDouble() * 2 * radius - radius;
                if (x * x + y * y <= radius * radius) {
                    return new double[]{x + x_center, y + y_center};
                }
            }
        }
    }
}

