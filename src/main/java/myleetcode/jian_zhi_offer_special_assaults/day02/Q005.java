package myleetcode.jian_zhi_offer_special_assaults.day02;

public class Q005 {
//    public int maxProduct(String[] words) {
//        int res = 0;
//        for (int i = 0; i < words.length; i++) {
//            Set<Character> characterSet = new HashSet<>();
//            for (char c : words[i].toCharArray()) {
//                characterSet.add(c);
//            }
//loop1:      for (int j = i + 1; j < words.length; j++) {
//                for (char c : words[j].toCharArray()) {
//                    if (characterSet.contains(c)) {
//                        continue loop1;
//                    }
//                }
//                res = Math.max(words[i].length() * words[j].length(), res);
//            }
//        }
//        return res;
//    }


    public int maxProduct(String[] words) {
        int res = 0;
        int[] wordNums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordNums[i] |= (1 << (c - 'a')) ;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordNums[i] & wordNums[j]) == 0)
                res = Math.max(words[i].length() * words[j].length(), res);
            }
        }
        return res;
    }
}
