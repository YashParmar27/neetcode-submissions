public class TrieNode
{
    Map<Character,TrieNode> map;
    boolean endOfWord;

    public TrieNode()
    {
        map = new HashMap<>();
        endOfWord = false;
    }

    public void addWord(String word)
    {
        TrieNode curr = this;
        for (char c : word.toCharArray())
        {
            curr.map.putIfAbsent(c, new TrieNode());
            curr = curr.map.get(c);
        }
        curr.endOfWord = true;
    }
}

class Solution {
    Set<String> res;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
    
        int ROWS = board.length, COLS = board[0].length;

        TrieNode root = new TrieNode();
        res = new HashSet<>();
        visited = new boolean[ROWS][COLS];

        for (String word : words)
        {
            root.addWord(word);
        }

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                dfs(board, i, j, root, "");
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, String word)
    {
        int ROWS = board.length, COLS = board[0].length;
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || !node.map.containsKey(board[i][j]) || visited[i][j])
            return;
        
        visited[i][j] = true;
        node = node.map.get(board[i][j]);
        word += board[i][j];

        if (node.endOfWord)
            res.add(word);
        
        dfs(board, i, j - 1, node, word);
        dfs(board, i + 1, j, node, word);
        dfs(board, i - 1, j, node, word);
        dfs(board, i, j + 1, node, word);

        visited[i][j] = false;
    }
}
