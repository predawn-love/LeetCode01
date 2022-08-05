package myleetcode.string;

public class Q165CompareVersionNumbers {
    public int compareVersion(String v1, String v2) {
        int i = 0;
        int j = 0;
        while (i < v1.length() || j < v2.length()) {
            int x = i, y = j;
            while (i < v1.length() && v1.charAt(i) != '.') {
                i++;
            }
            while (j < v2.length() && v2.charAt(j) != '.') {
                j++;
            }
            int flag = Integer.compare(x == i ? 0 : Integer.valueOf(v1.substring(x, i)), y == j ? 0 : Integer.valueOf(v2.substring(y, j)));
            if (flag > 0) {
                return 1;
            } else if (flag < 0) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.0";
        String v2 = "1.00";
        System.out.println(new Q165CompareVersionNumbers().compareVersion(v1, v2));
    }
}
