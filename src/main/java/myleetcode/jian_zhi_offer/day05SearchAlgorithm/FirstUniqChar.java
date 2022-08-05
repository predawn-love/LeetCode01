package myleetcode.jian_zhi_offer.day05SearchAlgorithm;

import java.util.LinkedHashMap;

/***
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 */
public class FirstUniqChar {
//    public char firstUniqChar(String str) {
//        char res = ' ';
//        char[] chars = str.toCharArray();
//        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
//        for (char c : chars) {
//            linkedHashMap.put(c, linkedHashMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
//            if (entry.getValue().equals(1) && res == ' ') {
//                return entry.getKey();
//            }
//        }
//        return res;
//    }

    char res = ' ';
    public char firstUniqChar(String str) {
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char c : chars) {
            linkedHashMap.put(c, linkedHashMap.getOrDefault(c, 0) + 1);
        }

        linkedHashMap.forEach((k, v) -> {
            if (v.equals(1) && res == ' ') {
                res = k;
            }
        });
        return res;
    }
}
