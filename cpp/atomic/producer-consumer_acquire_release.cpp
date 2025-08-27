#include <atomic>
#include <cstdio>
#include <thread>
#include <vector>

void producer(std::atomic<bool>* is_ready, int* data) {
  *data = 10;
  is_ready->store(true, std::memory_order_release);
}

void consumer(std::atomic<bool>* is_ready, int* data) {
  // data 준비까지 대기
  while (!is_ready->load(std::memory_order_acquire));

  printf("Data : %d\n", *data);
}

int main() {
  std::vector<std::thread> threads;

  std::atomic<bool> is_ready(false);
  int data = 0;

  threads.push_back(std::thread(producer, &is_ready, &data));
  threads.push_back(std::thread(consumer, &is_ready, &data));

  for (int i = 0; i < threads.size(); i++) {
    threads[i].join();
  }

  return 0;
}