#include <iostream>
using namespace std;

int main() {
    
  int n=0;
  cin >> n;

  pair<int, int>* meetings = new pair<int, int>[n];
  vector<pair<int, int>> answerVec;

  int tempS, tempE;
  for(int i=0; i<n; i++){
    cin >> tempS >> tempE;
    meetings[i].first = tempS;
    meetings[i].second = tempE;
  }

  int k =0;
  int a = 1;
  for(int i=1; i<n; i++){
    if(meetings[i] >= meetings[k]){
      a++;
      k = i;
      answerVec.push_back(meetings[i]);
    }
  }



  return 0;
}
