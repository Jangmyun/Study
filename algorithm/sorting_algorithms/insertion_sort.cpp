#include <fstream>
#include <iostream>
#include <string>
using namespace std;

int g_counter = 0;

void printArr(int arr[], int n) {
  for (int i = 0; i < n; i++) cout << arr[i] << " ";
}

void insertion_sort(int arr[], int n) {
  int key, j;

  for (int i = 1; i < n; i++) {
    key = arr[i];
    g_counter++;

    j = i - 1;
    g_counter++;

    while (j >= 0 && arr[j] > key) {
      g_counter++;

      arr[j + 1] = arr[j];
      g_counter++;

      j--;
      g_counter++;
    }

    arr[j + 1] = key;
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
  insertion_sort(arr, n);
  cout << "g_count: " << g_counter << endl;
  return 0;
}
