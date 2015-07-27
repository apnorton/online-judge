#include<iostream>
#include<string>
using namespace std;

//treat the first 9 bits as the table.
int f(int x) {
  int result = 0;

  //Corners
  result |= ((x >> 3) ^ (x >> 1)) & 1;//<< 0
  result |= (((x >> 1) ^ (x >> 5)) & 1) << 2;
  result |= (((x >> 3) ^ (x >> 7)) & 1) << 6;
  result |= (((x >> 7) ^ (x >> 5)) & 1) << 8;

  //Edges
  result |= (((x >> 0) ^ (x >> 2) ^ (x>>4)) & 1) << 1;
  result |= (((x >> 6) ^ (x >> 0) ^ (x>>4)) & 1) << 3;
  result |= (((x >> 8) ^ (x >> 6) ^ (x>>4)) & 1) << 7;
  result |= (((x >> 2) ^ (x >> 8) ^ (x>>4)) & 1) << 5;

  //Center
  result |= (((x >> 1) ^ (x >> 3) ^ (x >> 7) ^ (x >> 5)) & 1) << 4;

  return result;
}

void print(int x) {
  cout <<((x >> 6) & 1)<<((x >> 7) & 1)<<((x >> 8) & 1)<< endl;
  cout <<((x >> 3) & 1)<<((x >> 4) & 1)<<((x >> 5) & 1)<< endl;
  cout <<((x >> 0) & 1)<<((x >> 1) & 1)<<((x >> 2) & 1)<< endl << endl;
}

int main() {
  int numCases;
  for (cin >> numCases; numCases--; ) {
    string l1, l2, l3;
    cin >> l1 >> l2 >> l3;
    int currBoard = 0;
    currBoard |= ((l1[0] == '1') << 6) | ((l1[1] == '1') << 7) | ((l1[2] == '1') << 8);
    currBoard |= ((l2[0] == '1') << 3) | ((l2[1] == '1') << 4) | ((l2[2] == '1') << 5);
    currBoard |= ((l3[0] == '1') << 0) | ((l3[1] == '1') << 1) | ((l3[2] == '1') << 2);
    
    int i;
    for (i = 0; currBoard > 0; currBoard = f(currBoard), i++)
      ;


    cout << i-1 << endl;

  }
  
}
