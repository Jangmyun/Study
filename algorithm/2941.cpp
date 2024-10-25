#include <iostream>
using namespace std;

bool charCheck(char prev, char curr, char next) {
  // c= c- dz= d- lj nj s= z=

  if (curr == '=') {
    if (prev == 'c' || prev == 'z' || prev == 's') {
      return true;
    }
  }
  return false;
}

int main() {
  string cStr;
  cin >> cStr;

  // 2 이하일 경우 예약문자인지만 체크하고 일치하면 1, 아니면 str길이 출력
  if (cStr.length() <= 2) {
    if (cStr == "c=" || cStr == "c-" || cStr == "d-" || cStr == "lj" ||
        cStr == "nj" || cStr == "s=" || cStr == "z=") {
      cout << 1;
      return 0;
    } else {
      cout << cStr.length();
      return 0;
    }
  }

  int cStrIndex = 0;
  int counter = 0;
  while (cStrIndex < cStr.length() - 2) {
  }

  return 0;
}