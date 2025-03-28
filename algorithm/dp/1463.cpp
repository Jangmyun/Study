#include <iostream>
using namespace std;

int n;
int dp[1000000];

/**
 * case
 * 1- 1번 연산
 * 2- 1번 연산
 * 3- 1번 연산
 * 4 - 2번 연산 (4->   2->1)
 * 5 - 3번 연산 (5->   4->2->1)
 * 6 - 2번 연산 (6->   2->1)
 * 7 - 3번 연산 (7->   6->2->1)
 * 8 - 3번 연산 (8->   4->2->1)
 * 9 - 2번 연산 (9->   3->1)
 * 10- 3번 연산 (10-> 9->3->1)
 * 11- 4번 연산 (11-> 10->9->3->1)
 * 12- 2 나눠보니 6=> 2번연산 3나눠보니 2번연산
 * 13- 안나눠지면 무조건 1빼고 시작 12-> 3번 +1 = 4번 연산
 * 14
 */

int main() {
  cin.tie(0);
  ios::sync_with_stdio(0);

  cin >> n;

  bool isDividable2 = false, isDividable3 = false;

  for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + 1;  // 먼저 -1 해본 값을 대입
    if (i % 2 == 0) {
      dp[i] = min(dp[i], dp[i / 2] + 1);
    }
    if (i % 3 == 0) {
      dp[i] = min(dp[i], dp[i / 3] + 1);
    }
  }

  cout << dp[n];

  return 0;
}