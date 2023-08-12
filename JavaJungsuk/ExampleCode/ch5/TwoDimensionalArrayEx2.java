package ExampleCode.ch5;

public class TwoDimensionalArrayEx2 {
    public static void main(String[] args) {
         int[][] score = {      //2차원 배열 생성
            {100, 100, 100},
            {20, 20 ,20},
            {30, 30, 30},
            {40, 40, 40},
            {50, 50, 50}
        };
        int korSum=0 , engSum=0, mathSum=0; //각 과목별 총점을 담을 변수 생성

        System.out.println("번호 국어 영어 수학 총점 평균");
        System.out.println("==================================");

        for(int i=0; i<score.length; i++){
            int sum=0;              //i 반복문 끝나고 다시 돌아올 때 개인 총점, 평균 초기화
            float avg=0.0f;

            korSum += score[i][0];  //각 과목별 총합
            engSum += score[i][1];
            mathSum += score[i][2];
            System.out.printf("%3d" , i+1); // 개인 번호

            for(int j=0; j<score[i].length; j++){   //j 반복문에서 총점 더하기
                sum += score[i][j];
                System.out.printf("%5d" , score[i][j]);
            }
            avg = (float)sum/score[i].length;   //j 반복문 종료 직후 총점에서 과목개수 (score[i].length) 나눠서 평균내기
            System.out.printf("%5d %5.1f%n", sum, avg); //총점이랑 평균 프린트하고 줄바꿈
        }
        System.out.println("============================");
        System.out.printf("총점 : %3d %3d %3d" , korSum, engSum, mathSum);
    }
}
