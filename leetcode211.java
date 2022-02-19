class WordDictionary {
    class Node {
        char c;
        Node children[];
        boolean isWord;

        public Node(char c) {
            this.c = c;
        }

        boolean find(String word, int idx) {
            if (idx == word.length())
                return isWord;
            char c = word.charAt(idx);
            if (c == '.') {
                for (Node child : children) {
                    if (child != null && find(word, idx + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (children[c - 'a'] == null)
                    return false;
                else
                    return children[c - 'a'].find(word, idx + 1);
            }
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node('/');
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] != null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return root.find(word, 0);
    }
}
