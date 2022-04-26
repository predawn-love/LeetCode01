package myleetcode.one_question_perday;

public class Q1185DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 输入年份之前的年份的天数贡献
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month > 2) {
            days += 1;
        }
        // 输入月份中的天数贡献
        days += day;
        return week[(days + 3) % 7];
    }
}
