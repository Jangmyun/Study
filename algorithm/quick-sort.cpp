#include <iostream>
using namespace std;


int partition(vector<int> &arr, int low, int high){
	int pivot = arr[high]; // last element as the pivot  

	int i = low-1;

	for(int j = low; j<= high-1; j++){
		
		if(arr[j] <= pivot){
			i++;
			swap(arr[i], arr[j]);
		}
	}

	swap(arr[i+1], arr[high]);

	return i+1;
}

void quick_sort(vector<int> &arr, int low, int high){
	
	if(low < high){
		int partitioning_index = partition(arr, low, high);
	  
    quick_sort(arr, low, partitioning_index-1);
    quick_sort(arr, partitioning_index+1, high);
	}
}

int main() {
  vector<int> arr = {10, 7, 8, 9, 1, 5};
  int n = arr.size();

  quick_sort(arr, 0, n-1);

  for(int value : arr) cout << value << " ";


  return 0;
}
