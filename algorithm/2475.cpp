#include <math.h>

#include <iostream>
using namespace std;

int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;

  int powsum = (pow(a, 2) + pow(b, 2) + pow(c, 2) + pow(d, 2) + pow(e, 2));

  int result = powsum % 10;

  cout << result;

  return 0;
}