// 4796번 : 캠핑

package algorithm.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Camping {
  public static void main(String[] args) throws IOException {
    // String 입력을 위한 BufferedReader 객체 생성
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // case의 개수를 모르기때문에 동적 할당이 가능한 ArrayList 사용
    // ArrayList의 타입은 int[]로 설정
    ArrayList<int[]> caseArrayList = new ArrayList<>();

    // 입력값은 입력을 종료할 때를 제외하고 모두 1보다 크기 때문에
    // ArrayList<int[]> 의 마지막 int 배열의 요소가 0인지 여부에 따라 계속해서 테스트 케이스를 입력받을지 결정함
    // do while 문으로 초기 caseArrayList 상태에 상관없이 무조건 한번이상 실행하도록 함
    do {
      String testCase = br.readLine();
      StringTokenizer st = new StringTokenizer(testCase);
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      caseArrayList.add(new int[] { L, P, V });
    } while (caseArrayList.get(caseArrayList.size() - 1)[0] != 0);

    // 0 0 0 으로 입력받은 마지막 부분은 제거
    caseArrayList.remove(caseArrayList.size() - 1);

    // 입력받은 테스트 케이스 ArrayList를 함수에 전달
    campingDays(caseArrayList);
  }

  private static void campingDays(ArrayList<int[]> caseArrayList) {
    // ArrayList size 길이의 배열 생성
    int[] caseResultArr = new int[caseArrayList.size()];

    // 배열 길이만큼 반복문 수행
    for (int i = 0; i < caseResultArr.length; i++) {
      int caseResult = 0; // 결과값 담을 변수 caseResult

      // caseArrayList 인덱스의 각 요소를 L, P, V에 대입
      int L = caseArrayList.get(i)[0];
      int P = caseArrayList.get(i)[1];
      int V = caseArrayList.get(i)[2];

      // V일의 휴가에서 캠핑장은 연속하는 P일 중 L일동안 사용할 수 있다.
      // 휴가중 몇번의 연속하는 P일이 나오는가 => V/P
      // P일 중 L일 동안 사용가능하므로 L*(V/P) 일 사용가능하다.
      caseResult += L * (V / P);

      // V를 P로 나누고 남은 일수가 L보다 작을 때 그 남은 일수는 모두 캠핑장을 이용가능
      // 남은 일수가 L보다 크고 P보다 작을 때는 L일동안 캠핑장 이용가능
      if (L > V % P) {
        caseResult += V % P;
      } else {
        caseResult += L;
      }
      caseResultArr[i] = caseResult;
    }

    // 결과값을 출력
    for (int i = 0; i < caseResultArr.length; i++) {
      System.out.printf("Case %d: %d", i + 1, caseResultArr[i]);
      System.out.println();
    }
  }
}
