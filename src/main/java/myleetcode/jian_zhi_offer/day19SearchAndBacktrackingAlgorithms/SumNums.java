package myleetcode.jian_zhi_offer.day19SearchAndBacktrackingAlgorithms;

public class SumNums {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
