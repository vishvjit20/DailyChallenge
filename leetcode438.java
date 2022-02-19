import java.util.*;

public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int map[] = new int[26];
        List<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray())
            map[c - 'a']++;
        int st = 0, end = 0;
        while (end < s.length()) {
            if (map[s.charAt(end) - 'a'] > 0) {
                map[s.charAt(end++) - 'a']--;
                if (end - st == p.length()) {
                    result.add(st);
                }
            } else if (st == end) {
                st++;
                end++;
            } else
                map[s.charAt(st++) - 'a']++;
        }
        return result;
    }
}
