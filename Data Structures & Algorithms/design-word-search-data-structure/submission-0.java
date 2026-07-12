class TrieNode
{
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray())
        {
            cur.map.putIfAbsent(c, new TrieNode());
            cur = cur.map.get(c);
        }
        cur.endOfWord = true;
    }
    
    public boolean helper(String word, int index, TrieNode node)
    {
        if (index == word.length())
            return node.endOfWord;
        char c = word.charAt(index);

        if (c != '.')
        {
            if (!node.map.containsKey(c))
                return false;
            return helper(word, index + 1, node.map.get(c));
        }

        for (TrieNode child : node.map.values())
        {
            if (helper(word, index + 1, child))
                return true;
        }

        return false;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }
}
