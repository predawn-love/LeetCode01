package myleetcode.one_question_perday;

import java.util.HashSet;
import java.util.Set;

public class Q929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean metAtSymbol = false;
            boolean metPlusSymbol = false;
            for (char c : email.toCharArray()) {
                if (metAtSymbol) {
                    sb.append(c);
                    continue;
                }
                if (metPlusSymbol) {
                    if (c == '@') {
                        sb.append(c);
                        metAtSymbol = true;
                    }
                } else {
                    if (c == '+') {
                        metPlusSymbol = true;
                    } else if (c == '@') {
                        sb.append(c);
                        metAtSymbol = true;
                    } else if (c == '.'){
                        continue;
                    } else {
                        sb.append(c);
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
