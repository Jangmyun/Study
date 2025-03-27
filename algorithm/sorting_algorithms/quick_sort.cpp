#include <fstream>
#include <iostream>
#include <string>
using namespace std;

int g_counter = 0;

void printArr(int arr[], int n) {
  for (int i = 0; i < n; i++) cout << arr[i] << " ";
}

// low = start point
// high = end point
int partition(int arr[], int low, int high) {
  int pivot = arr[high];  // last element as the pivot
  int i = low - 1;
  g_counter += 2;

  for (int j = low; j <= high - 1; j++) {
    if (arr[j] <= pivot) {
      i++;
      swap(arr[i], arr[j]);
      g_counter += 2;
    }
  }

  swap(arr[i + 1], arr[high]);
  g_counter++;

  return i + 1;
}

void quick_sort(int arr[], int low, int high) {
  if (low < high) {
    int pivot_index = partition(arr, low, high);
    g_counter++;

    quick_sort(arr, low, pivot_index - 1);
    quick_sort(arr, pivot_index + 1, high);
    g_counter += 2;
  }
}

int main() {
  int input;
  cout << "Problem Selection (1-5)> ";
  cin >> input;
  string filename = "prob" + to_string(input) + ".txt";

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

  quick_sort(arr, 0, n - 1);

  cout << "g_count: " << g_counter << endl;

  return 0;
}
