package myleetcode.jian_zhi_offer.day03;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        int moveNum = n % length;
        return String.format("%s%s", s.substring(moveNum), s.substring(0, moveNum));
    }
}
