package CodingTest.심화;
import java.io.*;
import java.util.StringTokenizer;
public class N2_3003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] chessTemplate = {1, 1, 2, 2, 2, 8};
        int[] dongHyukPieces = new int[chessTemplate.length];
        String pieceString = br.readLine();
        StringTokenizer st = new StringTokenizer(pieceString);
        
        for(int i=0; i<chessTemplate.length; i++ ){
            int a = Integer.parseInt(st.nextToken());
            dongHyukPieces[i] = chessTemplate[i] - a;
            System.out.printf("%d ",dongHyukPieces[i]);
        }
    }
}
