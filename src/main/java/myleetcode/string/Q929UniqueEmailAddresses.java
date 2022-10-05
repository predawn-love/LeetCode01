package myleetcode.string;

import java.util.HashSet;

public class Q929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String s : emails) {
            int at = s.indexOf('@');
            StringBuffer name = new StringBuffer("");
            for (char c : s.substring(0, at).toCharArray()) {
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    name.append(c);
                }
            }
            name.append(s.substring(at));
            hs.add(name.toString());
        }
        return hs.size();
    }
}
