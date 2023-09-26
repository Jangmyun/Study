package CodingTest.backjoon.심화;
import java.io.*;
import java.util.ArrayList;
public class N5_1157 {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
      String str = br.readLine();
    }
    static char findMostChar(String str){
      String caseStr = str.toUpperCase();
      int count = 0;
      int resultChar = '?';
      ArrayList<Integer> countList = new ArrayList<>();
      ArrayList<Character> charList = new ArrayList<>();
      for(int i=0; i<caseStr.length(); i++){
        count = 0;
        char currentChar = caseStr.charAt(i);
        if( !charList.contains(currentChar)){
          charList.add(currentChar);
          
          for(int j=i+1; j<caseStr.length(); j++){
            if(currentChar == caseStr.charAt(j)){
              count++;
            }
          }
          countList.add(count);
          
        }
      }
    }
    
}