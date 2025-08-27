#include <iostream>
#include <vector>

struct Person {
  std::string name;
  int age;
};

int main() {
  // 기본적인 사용법
  auto add = [](int a, int b) { return a + b; };
  std::cout << "add(5,3) = " << add(5, 3) << std::endl;

  // 반환타입 명시적 지정
  auto multiply = [](double a, double b) -> double { return a * b; };
  std::cout << "multiply(2.5, 4.0) = " << multiply(2.5, 4.0) << std::endl;

  // capture절 사용
  int x = 10;
  int y = 20;

  // 값으로 capture
  auto lambda_val_capture = [=]() -> void {
    std::cout << "Captured value x:" << x << " y:" << y << std::endl;
  };
  lambda_val_capture();

  // 참조로 capture
  auto lambda_ref_capture = [&]() -> void {
    x = 100;
    y = 200;
  };
  lambda_ref_capture();
  // 람다 외부에서 선언된 x,y 변수 변경됨
  std::cout << "Captured ref x:" << x << " y:" << y << std::endl;

  // mutable 키워드 사용하여 값으로 capture된 변수 수정
  int count = 0;
  auto increment_captured_count = [count]() mutable {
    count++;
    std::cout << "Mutable lambda count:" << count << std::endl;
  };
  increment_captured_count();
  increment_captured_count();
  // 원본 count는 증가하지 않음
  std::cout << "Original value count:" << count << std::endl;

  // STL 알고리즘과 함께 사용
  std::vector<int> numbers = {6, 4, 2, 7, 5, 9, 8};
  // 내림차순 정렬
  std::sort(numbers.begin(), numbers.end(), [](int a, int b) { return a > b; });

  // for_each와 람다 사용한 출력
  std::cout << "Sorted vector : ";
  std::for_each(numbers.begin(), numbers.end(),
                [](int n) { std::cout << n << " "; });
  std::cout << std::endl;

  // find_if와 람다로 첫 번째 짝수 찾기
  int first_even_threshold = 3;
  auto it_even = std::find_if(
      numbers.begin(), numbers.end(), [first_even_threshold](int num) {
        return (num % 2 == 0) && (num > first_even_threshold);
      });

  (it_even != numbers.end())
      ? std::cout << "First even number greater than threshold : " << *it_even
                  << std::endl
      : std::cout << "No even number found";

  // generic 람다 (c++14부터)
  auto generic_add = [](auto a, auto b) { return a + b; };
  std::cout << "generic_add(5, 3) : " << generic_add(5, 3) << std::endl;
  std::cout << "generic_add(2.5, 3.0) : " << generic_add(2.5, 3.0) << std::endl;

  // std::function으로 람다 저장
  std::function<int(int, int)> func_add = [](int a, int b) { return a + b; };
  std::cout << "func_add(5,3) : " << func_add(5, 3) << std::endl;

  //=============================================//
  // 일반화된 캡처 (추가 공부 필요)
  auto ptr = std::make_unique<int>(42);
  // ptr의 소유권을 람다로 옮김
  auto generalized_capture_lambda = [value = std::move(ptr)]() {
    if (value) {
      std::cout << "6. Generalized capture: Value is " << *value << std::endl;
    } else {
      std::cout << "6. Generalized capture: Value is nullptr" << std::endl;
    }
  };
  generalized_capture_lambda();
  // 이제 main 함수의 ptr은 nullptr (또는 유효하지 않은 상태)
  if (!ptr) {
    std::cout << "   Original ptr is now null after std::move." << std::endl;
  }

  return 0;
}