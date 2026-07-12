class TrieNode
{
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray())
        {
            cur.map.putIfAbsent(c, new TrieNode());
            cur = cur.map.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray())
        {
            if (!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray())
        {
            if (!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return true;
    }
}
