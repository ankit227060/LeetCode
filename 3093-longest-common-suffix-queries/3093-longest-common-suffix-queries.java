class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        
        for(int i=0; i<wordsContainer.length; i++){
            int len = wordsContainer[i].length();
            trie.add(wordsContainer[i], len - 1, i);
        }
        
        int[] ans = new int[wordsQuery.length];
        for(int i=0; i<wordsQuery.length; i++){
            List<Integer> indices = trie.query(wordsQuery[i], wordsQuery[i].length() - 1);
            ans[i] = indices.get(0);
            for(int index : indices){
                if(wordsContainer[index].length() < wordsContainer[ans[i]].length()){
                    ans[i] = index;
                }
            }
        }
        return ans;
    }
    class Trie{
        List<Integer> indices;
        Trie[] children;
        Trie(){
            indices = new ArrayList<>();
            children = new Trie[26];
        }
        
        public void add(String str, int idx, int ID){
            if(idx < 0){
                this.indices.add(ID);
                return;
            }
            char c = str.charAt(idx);
            if(this.children[c-'a'] == null){
                this.children[c-'a'] = new Trie();
            }
            this.children[c-'a'].add(str, idx-1, ID);
            this.indices.add(ID);
        }
        public List<Integer> query(String str, int idx){
            if(idx < 0){
                return this.indices;
            }
            char c = str.charAt(idx);
            if(this.children[c-'a'] == null){
                return this.indices;
            }
            return this.children[c-'a'].query(str, idx-1);
        }
    }
}