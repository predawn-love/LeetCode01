package myleetcode.string;

import java.util.*;

public class Q49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> l = hm.getOrDefault(key, new LinkedList<String>());
            l.add(s);
            hm.put(key, l);
        }
        return new ArrayList<List<String>>(hm.values());
    }
}
