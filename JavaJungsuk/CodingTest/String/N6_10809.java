package CodingTest.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N6_10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(char i='a'; i<='z'; i++ ){
            System.out.printf("%d ",s.indexOf(i));
        }
    }
}

/*
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String s = br.readLine();
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
        for(int i = 0 ; i < s.length(); i++){
            char a = s.charAt(i);
            if(arr[a - 'a'] == -1){
                arr[a - 'a'] = i;
            }
        }
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
} 

 */
