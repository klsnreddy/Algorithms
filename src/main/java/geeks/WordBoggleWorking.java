package geeks;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by kreddy on 2/20/18.
 */
public class WordBoggleWorking {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    String[] dic;
    char[][] boggle;
    int dicLen, nRow, nCol;

    while(tc-- > 0) {
      dicLen = sc.nextInt();
      dic = new String[dicLen];
      for(int i = 0; i < dicLen; i++) {
        dic[i] = sc.next();
      }
      nRow = sc.nextInt();
      nCol = sc.nextInt();
      boggle = new char[nRow][nCol];
      for(int r = 0; r < nRow; r++) {
        for(int c = 0; c < nCol; c++) {
          boggle[r][c] = sc.next().charAt(0);
        }
      }
      Set<String> wordSet = findWords(dic, dicLen, boggle, nRow, nCol);
      System.out.println(wordSet.size() == 0 ? "-1" : wordSet.stream().collect(Collectors.joining(" ")));
    }
  }

  private static class Trie {
    boolean leaf;
    Trie[] children;
    Trie() {
      leaf = false;
      children = new Trie[256];
    }
    void addWord(String word) {
      int n = word.length();
      Trie node = this;
      char key;
      for(int i = 0; i < n; i++) {
        if(node.children[key = word.charAt(i)] == null) {
          node.children[key] = new Trie();
        }
        node = node.children[key];
      }
      node.leaf = true;
    }

    Trie getChild(char key) {
      return children[key];
    }
  }

  private static Set<String> findWords(String[] dic, int dicLen, char[][] boggle, int nRow, int nCol) {
    Trie dicTrie = new Trie();
    for(int i = 0; i < dicLen; i++) {
      dicTrie.addWord(dic[i]);
    }

    Set<String> wordSet = new TreeSet<>();
    boolean[][] vis = new boolean[nRow][nCol];
    for(int r = 0; r < nRow; r++) {
      for(int c = 0; c < nCol; c++) {
        findWords(dicTrie.getChild(boggle[r][c]), boggle, vis, nRow, nCol, r, c, String.valueOf(boggle[r][c]), wordSet);
      }
    }
    return wordSet;
  }

  private static void findWords(Trie dicTrie,
      char[][] boggle, boolean[][] vis, int nRow, int nCol, int row, int col,
      String word, Set<String> wordSet) {
    if(dicTrie == null) return;
    if(dicTrie.leaf) {
      wordSet.add(word);
    }

    vis[row][col] = true;
    for(int r = Math.max(0, row-1); r <= row+1 && r < nRow; r++) {
      for(int c = Math.max(0, col-1); c <= col+1 && c < nCol; c++) {
        if(!vis[r][c]) {
          findWords(dicTrie.getChild(boggle[r][c]),
              boggle, vis, nRow, nCol, r, c, word+boggle[r][c], wordSet);
        }

      }
    }
    vis[row][col] = false;
  }

  private static class Pair {
    int x, y;
    Pair(int a, int b) {
      x = a;
      y = b;
    }

    @Override
    public String toString() {
      return x + " " + y;
    }
  }

  private static void swap(int[] arr, int x, int y) {
    int _x = arr[x];
    arr[x] = arr[y];
    arr[y] = _x;
  }

  private static String flatString(int[] arr) {
    return Arrays.stream(arr)
        .mapToObj(String::valueOf)
        .collect(java.util.stream.Collectors.joining(" "));
  }

  private static String flatString2d(int[][] arr) {
    return Arrays.stream(arr)
        .flatMapToInt(a->Arrays.stream(a))
        .mapToObj(String::valueOf)
        .collect(java.util.stream.Collectors.joining(" "));
  }
}
