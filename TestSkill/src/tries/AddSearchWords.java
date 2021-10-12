package tries;

public class AddSearchWords {

  private static class Trie {
    boolean isWord = false;
    Trie[] chars = new Trie[26];
    public Trie() {
    }

    public void insert(String word) {
      if(word.length() == 0) {
        isWord = true;
        return;
      }

      char ch = word.charAt(0);
      Trie t = getNode(ch);
      chars[ch - 'a'] = t;

      t.insert(word.substring(1));
    }

    private Trie getNode(char ch) {
      return chars[ch - 'a'] == null ? new Trie() : chars[ch - 'a'];
    }

    public boolean search(String word) {
      if(word.length() ==0) {
        return isWord;
      }
      char ch = word.charAt(0);
      if(ch == '.') {
        return wildCardSearch(word);
      }

      if(chars[ch -'a'] != null) {
        return chars[ch - 'a'].search(word.substring(1));
      }
      return false;
    }

    private boolean wildCardSearch(String word) {
      for(Trie t : chars) {
        if(t == null) {
          continue;
        }
        if(t.search(word.substring(1))) {
          return true;
        }
      }
      return false;
    }
  }


  public static void main(String args[]) {
    Trie t = new Trie();
    t.insert("bad");
    t.insert("pad");
    t.insert("good");
    t.insert("job");
    t.insert("tap");

    boolean s = t.search("..d");
    s = t.search("bad");
    s = t.search("bed");

  }


}
