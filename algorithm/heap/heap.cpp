#include <iostream>
using namespace std;

void heapify(vector<int> &arr, int n, int i){
	int largest = i;
	int left = 2*i +1; // Left, Right child index
	int right = 2*i +2;

	if(left < n && arr[left] > arr[largest]){
		largest = left;
	}
	if(right< n && arr[right] > arr[largest]){
		largest = right;
	}

	if(largest != i) {
		swap(arr[i], arr[largest]);
		heapify(arr, n, largest);
	}
}

void build_max_heap(vector<int> &arr) {
	int n = arr.size();

	for(int i = n/2-1; i>=0; i--){
		heapify(arr, n, i);
	}
}

void heap_sort(vector<int> &arr) {
	build_max_heap(arr);

	for(int i=arr.size()-1; i>0; i--){
		swap(arr[0], arr[i]);
		heapify(arr, i, 0);
	}
}

int main() {
	vector<int> arr = {1, 10,3,9,5,15,44};

	heap_sort(arr);

	for(int value: arr) cout << value << " ";

	return 0;
}
