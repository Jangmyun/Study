#include <iostream>
using namespace std;

int main() {
  int n = 0;

  cin >> n;

  pair<int, int>* activities = new pair<int, int>[n];

  int tempStart = 0, tempEnd = 0;
  for (int i = 0; i < n; i++) {
    cin >> tempStart >> tempEnd;

    activities[i].first = tempStart;
    activities[i].second = tempEnd;
  }

  int k = 0;

  int answer = 1;
  for (int i = 1; i < n; i++) {
    if (activities[i].first >= activities[k].second) {
      answer++;
      k = i;
    }
  }

  cout << answer;

  return 0;
}