#include<iostream>
#include<string>
#include<cstdio>
using namespace std;

int main() {
  ios::sync_with_stdio(false); // for speedup

  int N;
  cin >> N;
  for (int test = 0; test < N; test++) {
    long totalCost = 0;
    int cost[256] = {0};
    unsigned char c1;

    int K;
    for (cin >> K; K--; ) {
      while(cin.get() != '\n')
        ; //get rid of newline character
      c1 = (unsigned char) cin.get();

      int v;
      cin >> v >> std::skipws;
      cost[c1] = v;
    }

    int M;
    cin >> M;
    string tmp;
    getline(cin, tmp); // get rid of trailing newline
    for (int i = 0; i < M; ) {
      unsigned char c = cin.get();
      if (c == '\n') i++; // We've read a line!

      totalCost += cost[c];
    }

    printf("%.2f$\n", totalCost / 100.0);
  }
  
  
  return 0;
}
