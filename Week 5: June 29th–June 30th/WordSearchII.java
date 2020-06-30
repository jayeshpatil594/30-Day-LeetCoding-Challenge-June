class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root = new TrieNode();
    public void buildTrie(String[] words){
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        //Time : O(n * m * 4 ^ (awl)) , where m*n => matrix size, 4 => recursion for four directions, awl => avg word length
        //Space : O(wl * m * n), where wl => word length.
        Set<String> res = new HashSet<>();
        buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(board, i, j, root, "", res);
                }
            }
        }
        return new ArrayList<>(res);
    }
    public void dfs(char[][] board, int i, int j, TrieNode node,String word, Set<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#'){
            return;
        }
        
        if(board[i][j] == '#' || node.children[board[i][j] - 'a'] == null){
            return;
        }
        word = word + board[i][j];
        node = node.children[board[i][j] - 'a'];
        if(node.isEnd){
            res.add(word);
        }
        //instead of having visited array we change it to #.
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(board, i + 1, j, node, word, res);
        dfs(board, i - 1, j, node, word, res);
        dfs(board, i, j + 1, node, word, res);
        dfs(board, i, j - 1, node, word, res);
        //restore back the original value
        board[i][j] = temp;
    }
}
