#include <iostream>

int main() {
  int a = 3;
  int &ref_a = a;

  ref_a = 4;
  std::cout << "a : " << a << std::endl;
  std::cout << "ref_a : " << ref_a << std::endl;

  return 0;
}