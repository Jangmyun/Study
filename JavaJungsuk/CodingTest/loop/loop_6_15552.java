package CodingTest.loop;
import java.io.*;
import java.util.StringTokenizer;
public class loop_6_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for( int i=0; i<t; i++){
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a+b + "\n");
        }
        bw.close();

        

    }
}
