#include <iostream>

class EmptyClass {};

class TestClass {
 public:
  [[no_unique_address]] EmptyClass e;
  int data;
};

int main() {
  TestClass tc;
  std::cout << "TestClass size : " << sizeof(TestClass) << std::endl;
  std::cout << &tc.e << std::endl;
  std::cout << &tc.data << std::endl;
}