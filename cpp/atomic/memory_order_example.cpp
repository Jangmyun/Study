#include <atomic>
#include <cstdio>
#include <thread>
#include <vector>

void t1(std::atomic<int>* a, std::atomic<int>* b) {
  b->store(1, std::memory_order_relaxed);      // b = 1 (쓰기)
  int x = a->load(std::memory_order_relaxed);  // x = a (읽기)

  printf("x : %d\n", x);
}

void t2(std::atomic<int>* a, std::atomic<int>* b) {
  a->store(1, std::memory_order_relaxed);      // a = 1 (쓰기)
  int y = b->load(std::memory_order_relaxed);  // y = b (읽기)

  printf("y : %d\n", y);
}

void test_memory_order_relaxed() {
  std::vector<std::thread> threads;

  std::atomic<int> a(0);
  std::atomic<int> b(0);

  threads.push_back(std::thread(t1, &a, &b));
  threads.push_back(std::thread(t2, &a, &b));

  for (int i = 0; i < threads.size(); i++) {
    threads[i].join();
  }
}

void test_memory_order_acquire_release() {}

int main() {
  // tests
  test_memory_order_relaxed();

  return 0;
}
