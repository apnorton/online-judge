#include<iostream>
#include<cmath>
using namespace std;
#define LIMIT 1000001


int main() {
  std::ios::sync_with_stdio(false);
  int fCt[LIMIT] = {0}; //initialize to zero

  for (int i = 2; i < LIMIT; i++) {
    if (fCt[i] == 0) { // It's prime!
      long pPow = i; // i to incrementing powers
      while (pPow < LIMIT) {  // > 0 for overflow catching
        for (long j = pPow; j < LIMIT; j += pPow)
          fCt[j]++;

        pPow *= i;
      }
    }
  }

  int memo[LIMIT]; 
  memo[1] = 0;

  for (int i = 2; i < LIMIT; i++)
    memo[i] = memo[i-1] + fCt[i];

  int a;
  cin >> a;
  while (cin.good()) {
    cout << memo[a] << '\n';
    cin >> a;
  }

  return 0;
}
