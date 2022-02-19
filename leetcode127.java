import java.util.*;

public class leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, Boolean> map = new HashMap<>();
        for (String word : wordList) {
            map.put(word, false);
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String w = q.poll();
                if (w.equals(endWord)) {
                    return len;
                }
                wordMatch(w, map, q);
            }
            len++;
        }
        return 0;
    }

    public void wordMatch(String w, Map<String, Boolean> map, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char word[] = w.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                word[i] = c;
                String s = String.valueOf(word);
                if (map.containsKey(s) && map.get(s) == false) {
                    q.add(s);
                    map.put(s, true);
                }
            }
        }
    }
}
