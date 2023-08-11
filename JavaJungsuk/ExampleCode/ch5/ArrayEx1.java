package Java의정석.ch5;

/**
 * ArrayEx1
 */
public class ArrayEx1 {
    public static void main(String[] args) {
        // int[] score;        // 1. 배열 score 선언 (참조변수 생성)
        // score = new int[5]; // 2. 배열 생성 (int타입 저장공간 5인 배열)
        
        int[] score = new int[5];
        score[3] = 100;

        for (int i =0; i<5; i++){
            System.out.printf("score[%d] = %d%n", i , score[i]);
        }
        
    }
}