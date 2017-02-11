import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LCS {
  
  public static int Lcs(String s1, String s2){
      int r = s1.length();
      int c = s2.length();
      int[][] res = new int[r+1][c+1];
    
      char[] c1 = s1.toCharArray();
      char[] c2 = s2.toCharArray();
    
      for(int i=1; i<r; i++)
        res[i][0] = 0;
      for(int j=1; j<c; j++)
        res[0][j] = 0;
    
      for(int i=1; i<r; i++){
        for(int j=1; j<c; j++){
          res[i][j] = -1;
        }
      }
    
       for(int i=1; i<=r; i++){
        for(int j=1; j<=c; j++){
            
            if(c1[i-1] == c2 [j-1]){
              res[i][j] = 1 + res[i-1][j-1];
            }else{
              res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
            }
        
        }
       }
    
    return res[r][c];  
  
  }
  
  
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");
    
    // String s1 = "KABCMA";
    // String s2 = "MABCKA";
    String s1 = "KABccckCM";
    String s2 = "MABccckCK";
    
    System.out.println("RESULT:" + Lcs(s1, s2));

    //for (String string : strings) {
      // System.out.println(string);
    // }
  }
}
