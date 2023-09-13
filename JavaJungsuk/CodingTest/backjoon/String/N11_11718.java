package CodingTest.backjoon.String;
import java.io.*;
import java.util.ArrayList;


public class N11_11718 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<char[]> chrList = new ArrayList<>();
        String input = "";
        while((input = br.readLine()) != null){
            chrList.add(input.toCharArray());
        }
        for( int i=0; i<chrList.size(); i++){
            for( int j=0; j< chrList.get(i).length; j++){
                System.out.printf("%c" , chrList.get(i)[j]);
            }
            System.out.println();
        }
    }
}
