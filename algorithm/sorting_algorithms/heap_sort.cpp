#include <fstream>
#include <iostream>
#include <string>
using namespace std;

int g_counter = 0;

void printArr(int arr[], int n) {
  for (int i = 0; i < n; i++) cout << arr[i] << " ";
}

void heapify(int arr[], int n, int i) {
  int largest = i;
  int left = 2 * i + 1;
  int right = 2 * i + 2;
  g_counter += 3;

  if (left < n && arr[left] > arr[largest]) {
    largest = left;
    g_counter++;
  }
  if (right < n && arr[right] > arr[largest]) {
    largest = right;
    g_counter++;
  }
  if (largest != i) {
    swap(arr[i], arr[largest]);
    g_counter++;
    heapify(arr, n, largest);
  }
}

void build_heap(int arr[], int n) {
  for (int i = n / 2 - 1; i >= 0; i--) {
    heapify(arr, n, i);
    g_counter++;
  }
}

void heap_sort(int arr[], int n) {
  build_heap(arr, n);

  for (int i = n - 1; i > 0; i--) {
    swap(arr[0], arr[i]);
    g_counter++;
    heapify(arr, i, 0);
    g_counter++;
  }
}

int main() {
  int input;
  cout << "Problem Selection (1-5)>  ";
  cin >> input;
  string filename = "prob" + to_string(input) + ".txt";  // get filename;

  int arr[1000];

  fstream fs;
  fs.open(filename);

  if (!fs.is_open()) {
    cout << "Empty file." << endl;
    return 0;
  }

  int n = -1;
  string tmp;
  while (getline(fs, tmp)) {
    n++;
    arr[n] = stoi(tmp);
  }
  n++;

  heap_sort(arr, n);
  cout << "g_count: " << g_counter << endl;

  return 0;
}