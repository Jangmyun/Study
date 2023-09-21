package CodingTest.backjoon.심화;
import java.io.*;
public class N4_10988 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word= br.readLine().toCharArray();

        int i=0;
        int isPalindrome = 1;
        while ( i <= word.length-1-i) {
            if( word[i] != word[word.length-1-i]){
                isPalindrome = 0;
            }
            i++;
        }
        System.out.println(isPalindrome);
    }
}
